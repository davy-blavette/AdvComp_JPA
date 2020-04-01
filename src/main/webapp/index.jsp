<jsp:include page="/include/header.jsp">
    <jsp:param name="pageName" value="index"/>
</jsp:include>

<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*,edu.aisl07.advcomp.authentification.entity.impl.UtilisateurImpl"%>	

<form class="form-signin mt-4" action="">
  <div class="text-center mb-4">
    <img class="mb-4" src="/AdvComp_JPA/images/j2ee.png" alt="">
    <h1 class="h3 mb-3 font-weight-normal">AdvComp_JPA</h1>
    <p>Projet examen GLG203<code>JEE</code> Techno.. <a href="#">EJB, Pattern, JPA</a></p>
  </div>

  <div class="form-label-group">
    <input type="text" id="login" name="login" class="form-control" placeholder="Login" required autofocus>
    <label for="inputLogin">Login</label>
  </div>

  <div class="form-label-group">
    <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
    <label for="inputPassword">Password</label>
  </div>

  <div class="checkbox mb-3">
    <label>
      <input type="checkbox" value="remember-me"> Remember me
    </label>
  </div>
  <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>

</form>
<jsp:include page="/include/footer.jsp" />