<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>ICONECTIV</title>  
    <style>
      .username.ng-valid {
          background-color: lightgreen;
      }
      .username.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .username.ng-dirty.ng-invalid-minlength {
          background-color: yellow;
      }
      .email.ng-valid {
          background-color: lightgreen;
      }
      .email.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .email.ng-dirty.ng-invalid-email {
          background-color: yellow;
      }
    </style>
     <link rel="stylesheet" href="/css/bootstrap.min.css">
     <link href="<c:url value='css/app.css' />" rel="stylesheet"></link>
  </head>
  <body ng-app="myApp" class="ng-cloak">
      <div class="generic-container" ng-controller="UserController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">User Registration Form </span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.user.id" />
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Usuario</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.user.username" name="uname" class="username form-control input-sm" placeholder="Ingresa usuario" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.uname.$error.required">Esto es un campo requerido</span>
                                      <span ng-show="myForm.uname.$error.minlength">Longitud minima requerida 3</span>
                                      <span ng-show="myForm.uname.$invalid">Este nombre es invalido</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                       <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Contraseña</label>
                              <div class="col-md-7">
                                  <input type="password" ng-model="ctrl.user.password" name="pass" class="username form-control input-sm" placeholder="Ingresa contraseña" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.pass.$error.required">Esto es un campo requerido</span>
                                      <span ng-show="myForm.pass.$error.minlength">Longitud minima requerida 3</span>
                                      <span ng-show="myForm.pass.$invalid">Este nombre es invalido</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                        
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Nombres</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.user.nombres" class="form-control input-sm" placeholder="Ingresa nombres. [This field is validation free]"/>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Apellidos</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.user.apellidos" class="form-control input-sm" placeholder="Ingresa apellidos. [This field is validation free]"/>
                              </div>
                          </div>
                      </div>
                      

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Correo</label>
                              <div class="col-md-7">
                                  <input type="email" ng-model="ctrl.user.email" name="email" class="email form-control input-sm" placeholder="Ingrese Correo" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.email.$error.required">Esto es un campo requerido</span>
                                      <span ng-show="myForm.email.$invalid">Este campo es invalido</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                      		<div class="form-group col-md-12">
					          <label class="col-md-2 control-lable">Tipo</label>
					          <div class="col-md-7">
					          		 <select ng-model="ctrl.user.type" class="form-control" name="type">
						                <option value="">Choose a size</option>
						                <option value="ADMINISTRADOR">Administrador</option>
						                <option value="DIGITADOR">Digitador</option>
						            </select>
					          </div>
	                      </div>
					</div>
					
					
                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.user.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Usuarios </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>Usuario</th>
                              <th>Nombres</th>
                              <th>Apellidos</th>
                              <th>Correo</th>
                              <th>Tipo</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in ctrl.users">
                              <td><span ng-bind="u.id"></span></td>
                              <td><span ng-bind="u.username"></span></td>
                              <td><span ng-bind="u.nombres"></span></td>
                              <td><span ng-bind="u.apellidos"></span></td>
                              <td><span ng-bind="u.email"></span></td>
                              <td><span ng-bind="u.type"></span></td>
                              <td>
                              
                              <button type="button" ng-click="ctrl.edit(u.id)" class="btn btn-success custom-width">Actualizar</button>  
                              <button type="button" ng-click="ctrl.remove(u.id)" class="btn btn-danger custom-width">Eliminar</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
      
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="<c:url value='js/app.js' />"></script>
      <script src="<c:url value='js/service/user_service.js' />"></script>
      <script src="<c:url value='js/controller/user_controller.js' />"></script>
  </body>
</html>