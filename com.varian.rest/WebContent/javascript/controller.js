
var app = angular.module('main',['ngCsv']).
controller('MyController',function($scope, $http) {
	//	$scope.SendToServer = function(name) {
	//        var responsePromise = $http.post("./save.jsp?id="+$scope.name);
	//      
	//        responsePromise.success(function(data, status, headers, config) {
	//        	
	//        });
	//        responsePromise.error(function(data, status, headers, config) {
	//            alert("Some error has occurred.Sorry for inconvience");
	//        });
	//        document.getElementById("userid").value = "";
	//        alert("value added to database");
	//    };

//	$scope.SendToServer = function(name) {
//		$http.post("./save.jsp?id=" + $scope.name).error(
//				function(data, status, headers, config) {
//					alert("Some error has occurred.Sorry for inconvience");
//				});
//		$scope.name = '';
//		alert("value added to database");
//	};
	  $scope.sample = "Sample";
	   $scope.getArray = [{a: 1, b:2}, {a:3, b:4}]; 
	
	$scope.SendToServer = function(name) {
	 $http({
		    url: "http://localhost:8080/com.varian.rest/api/patients",
		    method: "POST",
		    data: { 'message' :$scope.name }
		})
			$scope.name = '';
		    alert("value added to database");
	}

	$scope.LoadFromServer = function() {
		$http.get("http://localhost:8080/com.varian.rest/api/patients").then(onusercomplete, errorFunction);

	};

	var onusercomplete = function(response) {
		$scope.Mydata = response.data;
	
	};

	var errorFunction = function(response) {
		alert("Some error has occurred.Sorry for inconvience");
	};
});