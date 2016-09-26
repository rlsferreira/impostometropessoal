'use strict';
var module = angular.module('ImpostometroPessoalApp', [ 'ngAnimate' ]);

// factory
module.factory('impostometroCalculoService', function($http) {

    var service = {};

    service.calcula = function(usuarioValores) {

	var jsonForm = JSON.stringify(usuarioValores);
	var req = {
	    method : 'POST',
	    url : 'api/calculo/impostos',
	    data : jsonForm,
	    headers : {
	    // 'Content-Type' : 'application/x-www-form-urlencoded'
	    }
	}

	var promise = $http(req);
	return promise;
    }

    return service;
})

// controller
module.controller('ImpostometroCalculoController', function($scope, impostometroCalculoService) {

    $scope.resultadosCalculoImpostometro = '';
    $scope.formUsuarioValores = {};

    $scope.calculaImpostos = function() {

	var promise = impostometroCalculoService.calcula($scope.formUsuarioValores);
	promise.then(function(data, status, headers, config) {
	    $scope.resultadosCalculoImpostometro = data.data;
	}, function(data, status, headers, config) {
	    $scope.resultadosCalculoImpostometro = status;
	});

	console.log($scope.resultadosCalculoImpostometro);
    }

});
