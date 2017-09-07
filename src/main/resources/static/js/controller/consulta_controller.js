'use strict';

App.controller('ConsultaController', ['$scope', 'ConsultaService', function($scope, ConsultaService) {
          var self = this;
          self.consulta={id:null,identificadorMensaje:'',remitente:'',destinatario:'',fechaCreacionMensaje:'',identificadorProceso:'', 
        		  idMensaje:'', codigoReceptor:'', codigoCedente:'', tipoDocumentoIdentidad:'', numeroDocumentoIdentidad:'', cantidadNumeraciones:'',
          		  observaciones:'', nombreContacto:'', emailContacto:'', telefonoContacto:'', faxContacto:'', tipoServicio:'', cliente:'',
          		  inicioRango:'', finalRango:'', tipoPortabilidad:''};
          self.consultas=[];
              
          self.fetchAllConsultas = function(){
              ConsultaService.fetchAllConsultas()
                  .then(
      					       function(d) {
      						        self.consultas = d;
      					       },
            					function(errResponse){
            						console.error('Error while fetching Currencies');
            					}
      			       );
          };
           
          self.createConsulta = function(consulta){
        	  ConsultaService.createConsulta(consulta)
		              .then(
                      self.fetchAllConsultas, 
				              function(errResponse){
					               console.error('Error while creating Consulta.');
				              }	
                  );
          };

         self.updateConsulta = function(consulta, id){
        	 ConsultaService.updateConsulta(consulta, id)
		              .then(
				              self.fetchAllConsultas, 
				              function(errResponse){
					               console.error('Error while updating Consulta.');
				              }	
                  );
          };

         self.deleteConsulta = function(id){
        	 ConsultaService.deleteConsulta(id)
		              .then(
				              self.fetchAllConsultas, 
				              function(errResponse){
					               console.error('Error while deleting Consulta.');
				              }	
                  );
          };

          self.fetchAllConsultas();

          self.submit = function() {
              if(self.consulta.id==null){
                  console.log('Saving New Consulta', self.consulta);    
                  self.createConsulta(self.consulta);
              }else{
                  self.updateConsulta(self.consulta, self.consulta.id);
                  console.log('Consulta updated with id ', self.consulta.id);
              }
              self.reset();
          };
              
          self.edit = function(id){
              //console.log('id to be edited', id);
              console.log("-->"+self.consultas.length);
              for(var i = 0; i < self.consultas.length; i++){
                  if(self.consultas[i].id == id) {
                     self.consulta = angular.copy(self.consultas[i]);
                     break;
                  }
              }
          };
              
          self.remove = function(id){
              console.log('id to be deleted', id);
              if(self.consulta.id === id) {//clean form if the user to be deleted is shown there.
                 self.reset();
              }
              self.deleteConsulta(id);
          };

          
          self.reset = function(){
              self.consulta={id:null,identificadorMensaje:'',remitente:'',destinatario:'',fechaCreacionMensaje:'',identificadorProceso:'',
            		  idMensaje:'', codigoReceptor:'', codigoCedente:'', tipoDocumentoIdentidad:'', numeroDocumentoIdentidad:'', cantidadNumeraciones:'',
            		  observaciones:'', nombreContacto:'', emailContacto:'', telefonoContacto:'', faxContacto:'', tipoServicio:'', cliente:'',
              		  inicioRango:'', finalRango:'', tipoPortabilidad:''};
              $scope.myForm.$setPristine(); //reset Form
          };

      }]);
