app.controller("adminForumController", function($scope, $http, $location) {
	
	$scope.forum={forumId:0,forumName:'',forumContent:'',createDate:'',likes:0,username:'',status:'A'};
	$scope.forumdata;

	
	function fetchAllForum() {
		console.log("fetching all Admin forum");
		$http.get("http://localhost:8181/Collabaration/getAllForums")

		.then(function(response) {
			$scope.forumdata = response.data;
			console.log("data fetched from Admin forum");
		});

	};
	
   fetchAllForum();
	$scope.approveForum=function(forumId) 
	{
		console.log("entered in approve forum");
		$http.get('http://localhost:8181/Collabaration/approveForum/'+ forumId)
				.then(fetchAllForum(), 
						function(response) 
		{
			console.log("forum is approved");
		})
	}
	
	
	
	$scope.rejectForum=function(forumId)
	{
	$http.get('http://localhost:8181/Collabaration/rejectForum/'+forumId)
	.then(fetchAllForum(),function(response)
			{
		console.log('forum rejected');
	})
	}
});