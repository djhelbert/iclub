<#include "header.ftl">

<div class="container" style="margin-bottom:10px">
  <ul class="breadcrumb">
    <li class="active">Logo</li>
  </ul>
</div>

<div class="container" style="margin-bottom:10px">
  <div class="row">
    <div class="col-md-12">
        <div class="testiminial-block">
            <div class="row">
                <div class="col-md-2 col-sm-2"><img src="/file?id=${logo.id!''}" alt="Logo" class="img-responsive"/></div>
                <div class="col-md-8 col-sm-8 testimonial-content">
                    <h3>${logo.name!''}</h3>
                    <p>${logo.mimetype!''}</p>
                </div>
            </div>
        </div>
    </div>
  </div>
</div>

<div class="container" style="margin-bottom:10px">
  <ul class="breadcrumb">
    <li class="active">Scroller Images</li>
  </ul>
</div>

<div class="container" style="margin-bottom:10px">
  <div class="row">
    <div class="col-md-12">
        <#list scrollers as scroller>
        <div class="testiminial-block">
            <div class="row">
                <div class="col-md-2 col-sm-2"><img src="/file?id=${scroller.id!''}" alt="Scroller" class="img-responsive"/></div>
                <div class="col-md-8 col-sm-8 testimonial-content">
                    <h3>${scroller.name!''}</h3>
                    <p>${scroller.mimetype!''}</p>
                </div>
            </div>
        </div>
        </#list>
    </div>
  </div>
</div>

<#include "footer.ftl">