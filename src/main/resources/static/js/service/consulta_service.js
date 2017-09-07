'use strict';

App.factory('ConsultaService', ['$http', '$q', function($http, $q){

	return {
		
			fetchAllConsultas: function() {
					return $http.get('http://localhost:8080/consulta/')
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while fetching consultas');
										return $q.reject(errResponse);
									}
							);
			},
		    
		    createConsulta: function(consulta){
					return $http.post('http://localhost:8080/consulta/', consulta)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while creating consulta');
										return $q.reject(errResponse);
									}
							);
		    },
		    
		    updateConsulta: function(consulta, id){
					return $http.put('http://localhost:8080/consulta/'+id, consulta)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while updating consulta');
										return $q.reject(errResponse);
									}
							);
			},
		    
			deleteConsulta: function(id){
					return $http.delete('http://localhost:8080/consulta/'+id)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while deleting consulta');
										return $q.reject(errResponse);
									}
							);
			}
		
	};

}]);
