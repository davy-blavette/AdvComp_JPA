 <jsp:include page="/include/header.jsp">
    <jsp:param name="pageName" value="facturation"/>
</jsp:include>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*,projet.advcomp.facturation.Facturation"%>		



	<form method="POST" action="facturation">
      <div class="row">
        <div class="col-md-2">
          <label for="cc-name">Client</label>
          <input type="text" class="form-control" id="cc-name" name="client" placeholder="Client">
        </div>
        <div class="col-md-2">
          <label for="cc-number">Numéro</label>
          <input type="text" class="form-control" id="cc-number" name="numero" placeholder="Numéro">
        </div>
        <div class="col-md-2">
          <label for="cc-number">Date</label>
          <input type="date" class="form-control" id="cc-number" name="date" placeholder="yyyy-MM-dd">
        </div>
        <div class="col-md-2">
          <label for="cc-number">Montant</label>
          <input type="text" class="form-control" id="cc-number" name="montant" placeholder="Montant">
        </div>                
        <div class="col-md-4">
          <label for="cc-number">Action</label>
          <button class="btn btn-primary btn-sm btn-block" type="submit">Ajouter</button>
        </div>
      </div>          
    </form>

		<%
        @SuppressWarnings("unchecked") 
        List<Facturation> factures = (List<Facturation>)request.getAttribute("factures");
        if (factures != null) {
            for (Facturation facturation : factures) { %>
               <%= facturation %>	 <%
            }
        } 
        %>



<jsp:include page="/include/footer.jsp" />