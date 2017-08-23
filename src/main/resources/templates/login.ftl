<#include "header.ftl">

<div class="container" style="margin-top:30px">
  <div class="col-md-4 col-md-offset-4">
    <div class="panel panel-default">
      <div class="panel-heading"><h3 class="panel-title"><strong>Sign in </strong></h3>
        <div style="float:right; font-size: 80%; position: relative; top:-10px"><a href="#"></a></div>
      </div>

      <div class="panel-body">
      <form accept-charset="UTF-8" method="POST">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <#if error.isPresent()>
        <div class="alert alert-danger">
          <a class="close" data-dismiss="alert" href="#">×</a>Incorrect Username or Password!
        </div>
        </#if>
        <#if LOGO??>
        <div align="center">
           <img src="/file?id=${LOGO}" alt="Logo" >
        </div>
        </#if>
        <div style="margin-bottom: 12px" class="input-group">
          <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
          <input name="email" type="text" class="form-control" name="username" value="" placeholder="username or email">
        </div>

        <div style="margin-bottom: 12px" class="input-group">
          <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
          <input name="password" type="password" class="form-control" name="password" placeholder="password">
        </div>

        <div class="input-group">
          <div class="checkbox" style="margin-top: 0px;">
            <label><input id="remember-me" type="checkbox" name="remember-me" value="1"> Remember Me</label>
          </div>
        </div>

        <button type="submit" class="btn btn-success">Sign In</button>

        <hr style="margin-top:10px;margin-bottom:30px;" >

        <div class="form-group">
          <div style="font-size:85%">Don't have an account!</div>
          <div><a href="/register">Sign Up Here</a></div>
        </div>
      </form>
      </div>
    </div>
  </div>
</div>

<#include "footer.ftl">