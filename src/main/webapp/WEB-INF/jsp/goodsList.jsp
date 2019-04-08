<%--
  Created by IntelliJ IDEA.
  User: wenjie
  Date: 2019-03-30
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/statics/jquery.min.js"></script>
    <script type="text/javascript">
        function findSort(){
            $("#myform").submit();
        }

        /*currPageNo 当前页码   form 表单对象 */
        function pageNav(currPageNo,form){
            form.currPageNo.value = currPageNo;
            form.submit();
        }

        $(function(){
            //隔行变色
            $("tr:odd").css("background-color", 'yellow');
        });
    </script>

    <style>
        .container{
             width:700px; margin:0px auto; text-align: center;
        }
        table{
            width:100%; text-align:center;
        }
    </style>
</head>
<body>

    <div class="container">
        <form method="post" action="${pageContext.request.contextPath}/goods/list" id="myform">
            请选择商品分类：
            <select id="sorts" name="sortId" onchange="findSort()">
                <option value="0">全部</option>
                <c:forEach items="${goodsSortsList}" var="sorts">
                    <option value="${sorts.id}">${sorts.name}</option>
                </c:forEach>
            </select>
            <%--当前页码--%>
            <input type="hidden" name="currPageNo" value="1"/>
        </form>
        <table border="1" cellpadding="5" cellspacing="0" align="center">
            <tr>
                <th>商品编号</th>
                <th>商品名称</th>
                <th>商品分类</th>
                <th>产地</th>
                <th>生产日期</th>
                <th>单价(元)</th>
                <th>剩余数量</th>
                <th>修改</th>
            </tr>
            <c:forEach items="${goodsDtailList}" var="detail">
                <tr>
                    <td>${detail.id}</td>
                    <td>${detail.name}</td>
                    <td>${detail.goodsSort.name}</td>
                    <td>${detail.address}</td>
                    <td>
                        <fmt:formatDate value="${detail.createDate}" pattern="yyyy-mm-dd"/>
                     </td>
                    <td>${detail.price}</td>
                    <td>${detail.remaining}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/goods/toUpdatePage/${detail.id}">购买</a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <div><!--${pageContext.request.contextPath}/goodsdetail/findAll?pageNo=1-->
            <a href="javascript:pageNav(1,document.forms[0])">首页</a>
            <a href="javascript:pageNav(${page.currPageNo -1},document.forms[0])"> 上一页</a>
            <a href="javascript:pageNav(${page.currPageNo +1},document.forms[0])"> 下一页</a>
            <a href="javascript:pageNav(${page.totalPageCount},document.forms[0])"> 末页</a>
            第${page.currPageNo}页/共${page.totalPageCount}页
        </div>

    </div>

</body>
</html>