(function() {
  cola(function(model) {
    var mainPath, showMessage, submit;
    model.describe({
      username_: {
        validators: {
          $type: "required",
          message: ""
        }
      },
      password_: {
        validators: {
          $type: "required",
          message: ""
        }
      }
    });
    mainPath = "" + (App.prop("mainView"));
    model.set("username_", $.cookie("_username"), {
      path: "/"
    });
    showMessage = function(content) {
      return cola.widget("formSignIn").setMessages([
        {
          type: "error",
          text: content
        }
      ]);
    };
    submit = function() {
      alert(1);
      var data;
      data = model.get();
      cola.widget("containerSignIn").addClass("loading");
      return $.ajax({
        type: "POST",
        url: "./security_check_",
        data: JSON.stringify(data.toJSON()),
        contentType: "application/json"
      }).done(function(result) {
        cola.widget("containerSignIn").removeClass("loading");
        if (!result.type) {
          showMessage(result.message);
          return;
        }
        if (model.get("cacheInfo")) {
          $.cookie("_username", model.get("username_"), {
            path: "/",
            expires: 365
          });
        }
        return window.location = mainPath;
      }).fail(function() {
        cola.widget("containerSignIn").removeClass("loading");
      });
    };
    return model.action({
      signIn: function() {
        var data;
        cola.widget("formSignIn").setMessages(null);
        data = model.get();
        if (data.validate()) {
          return submit();
        } else {
          return showMessage("用户名或密码不能为空！");
        }
      }
    });
  });

}).call(this);
