/***
 * 加载普通笔记本
 */
function loadNormalNoteBook()
{
	$.post("/Spring/notebook/findNoteBooks.do",{},function(result)
	{
		if(result.success)
		{
			$.each(result.data,function()
			{
				$("#first_side_right ul").append('<li class="online"><a class="unchecked"><i class="fa fa-book" title="笔记本" rel="tooltip-bottom"></i> '+this.cn_notebook_name+'<button type="button" class="btn btn-default btn-xs btn_position btn_delete"><i class="fa fa-times"></i></button></a></li>');
				$("#first_side_right ul li:last").data("notebook",this);
			}		
			);
		}
		else
		{
			alert(result.message);
			if(result.message=="用户未登录")
			{
				setTimeout(
				function()
				{
					location.href="login.html";
				},2000
				);
			}
		}
	}		
	);

}

/***
 * 加载特殊笔记本
 */
function loadSpecialNoteBook()
{
	$.post("/Spring/notebook/findSpicalNoteBooks.do",{},function(result)
			{
				if(result.success)
				{
					$.each(result.data,function()
					{
						switch(this.cn_notebook_type_id)
						{
							case "1":
								$("#like_button").data("notebook",this);
								break;
							case "2":
								$("#rollback_button").data("notebook",this);
								break;
							case "3":
								$("#action_button").data("notebook",this);
								break;
							default:
								$("#first_side_right ul li:first").data("notebook",this);
						}
					}		
					);
					$("#first_side_right .checked").trigger("click");
				}
				else
				{
					alert(result.message);
				}
			}		
			);
}

/****
 * 添加笔记本
 */
function addNoteBook()
{
	var noteBookName=$("#input_notebook").val();
	if(noteBookName==null||noteBookName.trim()=="")
	{
		alert("笔记本名不能为空");
		return;
	}
	$.post("/Spring/notebook/addNoteBook.do",{"noteBookName":noteBookName},
	function(result)
	{
		if(result.success)
		{
			if(result.data!=null)
			{
				$(".close,.clance").trigger("click");
				$("#first_side_right ul").append('<li class="online"><a class="unchecked"><i class="fa fa-book" title="笔记本" rel="tooltip-bottom"></i> '+result.data.cn_notebook_name+'<button type="button" class="btn btn-default btn-xs btn_position btn_delete"><i class="fa fa-times"></i></button></a></li>');
				$("#first_side_right ul li:last").data("notebook",result.data);
			}
			else
			{

				alert("创建失败");
			}
		}
		else
		{
			alert(result.message);
		}
	}
	);
}

/***
 * 重命名笔记本
 */
function updateNoteBook()
{
	var noteBook=$(".checked").parent().data("notebook");
	var newName=$('#input_notebook_rename').val();
	
	if(newName==null)
	{
		alert("不能为空");
		return;
	}
	if(newName==noteBook.cn_notebook_name)
	{
		alert("名字不能重复");
		return;
	}
	/*
	 * "cn_notebook_name":newName,"cn_notebook_id":noteBook.cn_notebook_id,
		"cn_notebook_desc":"改的",
		"cn_user_id":noteBook.cn_user_id,"cn_notebook_type_id":noteBook.cn_notebook_type_id,"cn_notebook_createtime":noteBook.cn_notebook_createtime
	 */
	noteBook.cn_notebook_name=newName;
	$.post("/Spring/notebook/updatenotebook.do",noteBook,
	function(result)
	{
		if(result.success)
		{
			if(result.data==1)
			{
				$("#first_side_right li:gt(0)").remove();
				loadNormalNoteBook();
				
				alert("修改成功");
			}
			else
			{
				alert("修改失败");
			}
		}
		else
		{
			alert(result.message);
		}
	}
	);
//	alert("好吧");
}

/***
 * 删除笔记本
 */
function deleteNoteBook()
{
	var note=$("#second_side_right ul li").html();
	
	if(note!=null)
	{
		alert("该笔记本下还有笔记");
		return;
	}
	var book=$(".checked").parent().data("notebook");
	var name=book.cn_notebook_name;
	var user=book.cn_user_id;
	
	$.post("/Spring/notebook/deletenotebook.do",{"name":name,"user":user},
	function(result)
	{
		if(result.success)
		{
			if(result.data==1)
			{
				$("#first_side_right li:gt(0)").remove();
				loadNormalNoteBook();
				alert("删除成功");
			}
			else
			{
			alert("删除失败");
			}
		}
		else
		{
			alert(result.message);
		}
	});
}

/**
 * 将笔记本列表放置到select组件中
 */
function setNoteBookToSelect()
{
	var noteBooks=new Array();
	for(i=0;i<$("#first_side_right li").size();i++)
	{
		noteBooks[i]=$("#first_side_right li").eq(i).data("notebook");
	}

	$.each(noteBooks,function()
	{
		$("#moveSelect").append('<option value="'+this.cn_notebook_id+'">'+this.cn_notebook_name+'</option>');
		$("#replaySelect").append('<option value="'+this.cn_notebook_id+'">'+this.cn_notebook_name+'</option>');
	}
	);
}