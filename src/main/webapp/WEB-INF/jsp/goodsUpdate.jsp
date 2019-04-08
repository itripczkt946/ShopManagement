<%--
  Created by IntelliJ IDEA.
  User: wenjie
  Date: 2019-03-30
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购买商品页面</title>
    <script src="${pageContext.request.contextPath}/statics/jquery.min.js"></script>

    <style>
        .container { width:280px; margin:0px auto;}
        table{ width:100%; }
    </style>
</head>
<body>

<div class="container">
    <form id="myform" action="${pageContext.request.contextPath}/goods/updateGoods">
        <table border="1">
            <tr>
                <td colspan="2" align="center"><h1>购买商品</h1></td>
            </tr>
            <tr>
                <td>商品编号</td>
                <td>
                    <input type="text" name="id" value="${detail.id}" readonly="readonly"/>
                </td>
            </tr>
            <tr>
                <td>商品名称</td>
                <td>${detail.name}</td>
            </tr>
            <tr>
                <td>商品分类</td>
                <td>${detail.goodsSort.name}</td>
            </tr>
            <tr>
                <td>单价(元)</td>
                <td>
                    <input type="text" name="price" value="${detail.price}" readonly="readonly"/>
                </td>
            </tr>
            <tr>
                <td>剩余数量</td>
                <td>
                    <input type="text" name="remaining" value="${detail.remaining}" readonly="readonly"/>
                </td>
            </tr>
            <tr>
                <td>购买数量</td>
                <td>
                    <input type="text" id="num" onblur="calcPrice()" value="0"/>
                </td>
            </tr>
            <tr>
                <td>总金额(元)</td>
                <td>
                    <input type="text" name="totalPirce" />
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="购买" id="purchase"/>
                    <input type="button" value="返回" onclick="javascript:location.href='${pageContext.request.contextPath}/goods/list'" />
                </td>
            </tr>
        </table>
    </form>
</div>
<script>
    var  price = parseFloat($("input[name='price']").val());  //单价
    var number;  //购买数量
    var remaining = $("input[name='remaining']").val(); //得到剩余数量

    $(function(){
        function isInteger(obj) { //判断是整数，true表示是，false表示是小数。
            // 任何整数都会被1整除，即余数是0。利用这个规则来判断是否是整数
            return obj%1 === 0
        }

        $("#myform").submit(function(){  //表单提交函数, isNaN表示非数字。 isFinite判断是否是整数，true表示整数
            if (isNaN($("#num").val()) == true) {
                alert("购买数量必须是数字");
                return false;
            }

            if (isNaN($("#num").val()) == false && !isInteger($("#num").val())) {
                alert("购买数量必须是整数");
                return false;
            }

            if (parseInt($("#num").val()) == null || parseInt($("#num").val()) == 0) {
                alert("购买数量不能为空");
                return false;  //表单就不会被提交
            }

            if (parseInt(remaining) <= 0) {
                alert("余量不足，购买失败");
                return false;
            }
            return true;  //表单就会被提交。
        });
    });

    function calcPrice() {
        number = parseInt($("#num").val());  //购买数量
        $("input[name='totalPirce']").val(price * number);  //计算总金额。
        $("input[name='remaining']").val(remaining - number); //计算剩余数量
    }
</script>
</body>
</html>

