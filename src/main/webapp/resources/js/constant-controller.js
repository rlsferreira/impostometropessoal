angular.module('ImpostometroPessoalApp').controller('ImpostometroCalculoController', function($scope, $http) {

    $scope.constants = [];
    $http.get('/constants/findAll')
	    .success(function(retorno) {
	    	$scope.constants = retorno;
	    })
	    .error(function(erro) {
	    	console.log(erro);
	    });
});