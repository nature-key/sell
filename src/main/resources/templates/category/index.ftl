<html>
<#include "../common/header.ftl">
<body>

<div id="wrapper" class="toggled">

<#include "../common/nav.ftl">
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/sell/seller/category/save">
                        <div class="form-group">
                            <label >名称</label><input name="categoryName" type="text" class="form-control"  value="${(category.categoryName)!""}" />
                        </div>
                        <div class="form-group">
                            <label >type</label><input name="categoryType" type="number" class="form-control"  value="${(category.categoryType)!""}" />
                        </div>
                        <input hidden type="text" name="categoryId" value="${(category.categoryId)!''}">
                         <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>


<#--<#list orderDTOPage.content as orderDTO>-->


