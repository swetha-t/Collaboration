myapp.controller("BlogController",function($scope,$http)
{
	
	$scope.insertBlog=function()
	{
		console.log('Entered into InsertBlog');
		$http.post('http://localhost:8181/Collabaration/insertBlog',$scope.blog)
		.then(function(response)
				{
				console.log('Successful Blog Entered');
				});
	}
$scope.blog={blogId:1010,blogName:"",blogContent:"",createDate:"",likes:0,username:"",status:"NA"};
	
	$http.get("http://localhost:8181/Collabaration/getAllBlogs")
	.then(function(response)
	{
		$scope.blogdata=response.data;
	});

	
	
});











