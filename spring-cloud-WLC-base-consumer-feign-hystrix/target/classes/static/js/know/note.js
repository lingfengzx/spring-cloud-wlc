/***
 * 加载普通笔记
 */
function getNormalNoteList()
{
	//清空编辑笔记内容
	$("#input_note_title").val("");
	$("#myEditor").html("");
	var notebook=$(".checked").parent().data("notebook");
	var notebookId=notebook.cn_notebook_id;
	$.post("/Spring/note/findnoteall.do",{"noteBookId":notebookId},
	function(result)
	{
		if(result.success)
		{
			$.each(result.data,
			function()
			{
				$("#second_side_right ul").append('<li class="online"><a class="">'+
						'<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'+this.cn_note_title+'<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>'+
					'</a>'+
					'<div class="note_menu" tabindex="-1">'+
					'<dl>'+
							'<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>'+
							'<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>'+
							'<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>'+
						'</dl>'+
					'</div>'+
				'</li>');
				$("#second_side_right ul li:last").data("note",this);
			}
			);
		}
		else
		{
			alert(result.message);
		}
	}
	);
}

/***
 * 查询普通笔记内容
 */
function getNoteDetail()
{
	$("#input_note_title").val("");
	$("#myEditor").html("");
	var note=$("#second_side_right .checked").parent().data("note");
	var title=note.cn_note_title;
	var body=note.cn_note_body;
	$("#input_note_title").val(title);
	$("#myEditor").html(body);
	console.log("查询普通笔记内容");
}

/***
 * 创建普通笔记
 */
function createNormalNote()
{
	var noteName=$("#input_note").val();
	if(noteName==null||noteName.trim()=="")
	{
		alert("笔记标题不能为空");
		return;
	}
	var noteBook=$(".checked").parent().data("notebook");
	var noteBookId=noteBook.cn_notebook_id;
	$.post("/Spring/note/addnote.do",{"cn_note_title":noteName,"cn_notebook_id":noteBookId},
	function(result)
	{
		if(result.success)
		{
			if(result.data)
			{
				$("#second_side_right ul li").remove();
				getNormalNoteList();
				alert("创建笔记成功");
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
 * 更新普通笔记
 */
function updateNormalNote()
{
	var note=$("#second_side_right .checked").parent().data("note");
	var title=$("#input_note_title").val();
	var body=$("#myEditor").html();
	note.cn_note_title=title;
	note.cn_note_body=body;
	$.post("/know/saveKnow",note,
	function(result)
	{
		if(result.success)
		{
			if(result.data)
			{
				$("#second_side_right ul li").remove();
				getNormalNoteList();
				alert("保存成功");
			}
			else
			{
				alert("更新失败");
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
 * 删除普通笔记
 */
function deleteNormalNote()
{
	var note=$("#second_side_right .checked").parent().data("note");
	var recycleId=$("#rollback_button").data("notebook").cn_notebook_id;
	note.cn_notebook_id=recycleId;
	$.post("/Spring/note/removenote.do",note,
	function(result)
	{
		if(result.success)
		{
			if(result.data)
			{
				$('#pc_part_2 ul').empty();
				getNormalNoteList();
				$("#input_note_title").val("");
				$("#myEditor").html("");
				alert("删除普通笔记");
			}
			else
			{
				alert("不能删除");
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
 * 移动笔记
 */
function moveNote()
{
	var select;
	var note;
	var notebook=$("#rollback_button").hasClass("clicked");
	if($("#rollback_button").hasClass("clicked"))
	{
		select=$("#replaySelect");
		note=$("#four_side_right .checked").parent().data("note");
	}
	else
	{
		select=$("#moveSelect");
		note=$("#second_side_right .checked").parent().data("note");
	}
	if(select.val()=="")
	{
		alert("请选择笔记本");
		return;
	}
	/*var notebook=$("#first_side_right .checked").parent().data("notebook");
	if(notebook.cn_notebook_id==select.val())
	{
		alert("不能移动到当前笔记本");
		return;
	}*/

	var notebookId=select.val();
	note.cn_notebook_id=notebookId;
	
	$.post("/Spring/note/movenote.do",note,
	function(result)
	{
		if(result.success)
		{
			if(result.data)
			{
				$('#pc_part_4 ul').empty();
				getRecycleNoteList(notebook);
				$("#noput_note_title").text("");
				$("#fifth_side_right .module div:last").html("");
				$(".cancle").trigger("click");
			}
			else
			{
				alert("不能移动");
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
 * 分享笔记
 */
function createShareNote()
{
	var note=$("#second_side_right .checked").parent().data("note");
	$.post("/Spring/share/addshare.do",{"cn_share_title":note.cn_note_title,"cn_share_body":note.cn_note_body,"cn_note_id":note.cn_note_id},
	function(result)
	{
		if(result.success)
		{
			if(result.data)
			{
				$("footer div strong").text("分享成功").parent().fadeIn(100);
				setTimeout(function(){
					$("footer div").fadeOut(500);
				}, 1500);
			}
			else
			{
				alert("不能分享");
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
 * 查询回收站笔记列表
 */
function getRecycleNoteList(notebook)
{
	//清空预览笔记
	$("#noput_note_title").html("");
	$("#fifth_side_right .module #mydiv").remove();
	var notebookId=notebook.cn_notebook_id;
	$.post("/Spring/note/findrecyclenote.do",{"notebookId":notebookId},
	function(result)
	{
		if(result.success)
		{
			$("#four_side_right ul li").remove();

			$.each(result.data,
			function()
			{
				$("#four_side_right ul").append('<li class="disable"><a ><i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'+this.cn_note_title+'<button type="button" class="btn btn-default btn-xs btn_position btn_delete"><i class="fa fa-times"></i></button><button type="button" class="btn btn-default btn-xs btn_position_2 btn_replay"><i class="fa fa-reply"></i></button></a></li>');
				$("#four_side_right ul li:last").data("note",this);
			}
			);
		}
		else
		{
			alert(result.message);
		}
	}
	);
}

/***
 * 查看回收站笔记内容
 */
function getRecycleNoteDetail()
{
	$("#noput_note_title").html("");
	$("#fifth_side_right .module #mydiv").remove();
	var note=$("#four_side_right .checked").parent().data("note");
	
	$("#noput_note_title").html(note.cn_note_title);
	$("#fifth_side_right .module").append("<div id='mydiv'></div>");
	$("#fifth_side_right .module div:last").html(note.cn_note_body);
	console.log("查看回收站笔记内容");
}

/***
 * 删除回收站笔记
 */
function deleteRecycleNote()
{
	var note=$("#four_side_right .checked").parent().data("note");
	$.post("/Spring/note/deletenote.do",note,
			function(result)
			{
				if(result.success)
				{
					if(result.data)
					{
						$('#pc_part_4 ul').empty();
						getRecycleNoteList(notebook);
						$("#noput_note_title").text("");
						$(".cancle").trigger("click");
					}
					else
					{
						alert("不能删除");
					}
				}
				else
				{
					alert(result.message);
				}
			}
			);
	alert("删除回收站笔记");
}

/***
 * 搜索分享笔记列表
 */
function getShareNoteList(page)
{
	var title=$("#search_note").val();
	var count=0;
	if(page==0)
	{
	}
	else
	{
		count=$("#more_note").data("count");
		if(count==undefined)
		{
			count=0;
		}
	}
	console.log("搜索分享笔记");
	$.post("/Spring/share/findsharebytitle.do",{"title":title,"page":count},
	function(result)
	{
		if(result.success)
		{
			$.each(result.data,
			function()
			{
				$("#sixth_side_right ul").append('<li class="online"><a href="#"><i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'+this.cn_share_title+'<button type="button" class="btn btn-default btn-xs btn_position btn_like"><i class="fa fa-star-o"></i></button><div class="time"></div></a></li>');
				$("#sixth_side_right ul li:last").data("share",this);
			}
			);
			if($("#sixth_side_right ul li").length<10)
			{
				$("#more_note").data("count",count);
			}
			else
			{
				count++;
				$("#more_note").data("count",count);
			}
		}
	}
	);
}

/***
 * 查询分享笔记内容
 */
function getShareNoteDetail()
{
	$("#noput_note_title").html("");
	$("#fifth_side_right .module #mydiv").remove();
	var note=$("#sixth_side_right .checked").parent().data("share");
	
	$("#noput_note_title").html(note.cn_share_title);
	$("#fifth_side_right .module").append("<div id='mydiv'></div>");
	$("#fifth_side_right .module div:last").html(note.cn_share_body);
	console.log("查询分享笔记内容");
}

/***
 * 收藏分享笔记
 */
function likeShareNote(shareId,favoriteId)
{
	$.post("/Spring/like/addlikenote.do",{"shareId":shareId,"likeId":favoriteId},
	function(result)
	{
		if(result.success)
		{
			if(result.data)
			{
				alert("收藏分享笔记成功");
			}
			else
			{
				alert("不能收藏");
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
 * 加载收藏笔记
 */
function getLikeNoteList(likeNoteId)
{
	//清空预览笔记
	$("#noput_note_title").html("");
	$("#fifth_side_right .module #mydiv").remove();
	$.post("/Spring/like/findlikenote.do",{"likeId":likeNoteId},
	function(result)
	{
		if(result.success)
		{
			$.each(result.data,
			function()
			{
				$('#pc_part_7 ul').append('<li class="idle"><a ><i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'+this.cn_note_title+'<button type="button" class="btn btn-default btn-xs btn_position btn_delete"><i class="fa fa-times"></i></button></a></li>');
				$('#pc_part_7 ul li:last').data("note",this);
			});
		}
		else
		{
			alert(result.message);
		}
	}
	);
}

/***
 * 查看收藏笔记内容
 */
function getLikeNoteDetail(note)
{
	$("#noput_note_title").html("");
	$("#fifth_side_right .module #mydiv").remove();
	
	$("#noput_note_title").html(note.cn_note_title);
	$("#fifth_side_right .module").append("<div id='mydiv'></div>");
	$("#fifth_side_right .module div:last").html(note.cn_note_body);
	console.log("查询收藏笔记内容");
}

/***
 * 删除收藏笔记
 */
function deleteLikeNote(note)
{
	var likeNoteId=$("#like_button").data("notebook").cn_notebook_id;
	$.post("/Spring/like/deletelike.do",note,
	function(result)
	{
		if(result.success)
		{
			//每次加载前先清空所有li
			$('#pc_part_7 ul').empty();
			getLikeNoteList(likeNoteId);
			alert("删除收藏笔记成功");
		}
		else
		{
			alert(result.message);
		}
	}
	);
}

/***
 * 加载本用户参加活动笔记列表
 */
function getNoteActivityList(noteBookId)
{
	//清空预览笔记
	$("#noput_note_title").html("");
	$("#fifth_side_right .module #mydiv").remove();
	$.post("/Spring/note/findactivitynote.do",{"noteBookId":noteBookId},
	function(result)
	{
		if(result.success)
		{
			$.each(result.data,
			function()
			{
				$("#eighth_side_right ul").append('<li class="offline"><a ><i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'+this.cn_note_title+'</a></li>');
				$("#eighth_side_right ul li:last").data("note",this);
				alert("加载本用户参加活动笔记列表");
			}
			);
		}
		else
		{
			alert(result.message);
		}
	}
	);
}

/***
 * 查询参加活动的笔记内容
 */
function getActivityNoteDetail(note)
{

	$("#noput_note_title").html("");
	$("#fifth_side_right .module #mydiv").remove();
	
	$("#noput_note_title").html(note.cn_note_title);
	$("#fifth_side_right .module").append("<div id='mydiv'></div>");
	$("#fifth_side_right .module div:last").html(note.cn_note_body);
	console.log("查询参加活动的笔记内容");
}