myapp.controller("jobsController", function($scope, $http, $location,$rootScope) {
	
	var BASE_URL="http://localhost:8181/Collabaration"
	function fetchAllJobs() {
		console.log("fetched all jobs")
		$http.get(BASE_URL)

		.then(function(response) {
			$scope.jobsdata = response.data;
			console.log("all jobs fetched")
		});
	};
	
	fetchAllJobs();
	$scope.insertJobs = function() 
	{
		console.log("entered insertJob");
		$http.post("http://localhost:8181/Collabaration/insertJob",$scope.jobs)
				.then(fetchAllJobs(), function(response) {
			console.log("successful jobs entered");
		$location.path("/jobs")
		});
	}
	
	
});