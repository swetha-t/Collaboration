	myapp.controller("forumController",function($scope,$http,$location,$rootScope)
		
		{
		$scope.forum={forumId:'',forumName:'',forumContent:'',createDate:'',userId:'',status:"NA"}
		$scope.forum;

		
		
	var BASE_URL="http://localhost:8181/Collabaration"
	$scope.insertForum=function()
	{
		console.log('Entered into InsertForum');
		$http.post(BASE_URL+"/insertForum", $scope.forum).then(function(response)
				{
				console.log('Successful Forum Entered');
				});
	}


	
});










