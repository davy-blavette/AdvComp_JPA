<!DOCTYPE html>
<html lang="fr">
    <head>
        <title>AdvComp_JPA Facturation</title>
		<meta charset="UTF-8">        
		<meta name="viewport" content="width=device-width, initial-scale=1">
				
		<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		<%@page import="java.util.*,projet.advcomp.facturation.Facturation"%>		
		<% String pageName = request.getParameter("pageName"); %>

		<link rel="icon" type="image/png" href="/AdvComp_JPA/images/icons/favicon.ico"/>
		<link rel="stylesheet" type="text/css" href="/AdvComp_JPA/vendor/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="/AdvComp_JPA/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" type="text/css" href="/AdvComp_JPA/css/main.css"> 
    </head>
    <body>
      <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
      <a class="navbar-brand" href="#">Projet AdvComp_JPA</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item <% if(pageName.equals("index")){ %> active <% } %>">
            <a class="nav-link" href="/AdvComp_JPA">Connexion</a>
          </li>
           <li class="nav-item <% if(pageName.equals("facturation")){ %> active <% } %>">
            <a class="nav-link" href="/AdvComp_JPA/facturation">Facturation</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/AdvComp_JPA/facturation">Calcul Chaîné</a>
          </li>
          <li class="nav-item <% if(pageName.equals("facturation")){ %> active <% } %>">
            <a class="nav-link" href="/AdvComp_JPA/facturation">Facturation (Test)</a>
          </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
          <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
      </div>
    </nav>
    <main role="main" class="container">