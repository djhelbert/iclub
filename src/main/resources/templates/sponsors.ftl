<#include "header.ftl">

<div class="container" style="margin-bottom:10px">
  <ul class="breadcrumb">
    <li class="active">Our Sponsors</li>
  </ul>
</div>

<div class="container" style="margin-bottom:10px">
  <div class="row">
    <div class="col-md-12">
        <#list sponsors as sponsor>
        <div class="testiminial-block">
            <div class="row">
                <div class="col-md-2 col-sm-2"><a href="${sponsor.url!'#'}"><img src="/file?id=${sponsor.binaryFile.id!''}" alt="Logo" class="img-responsive"/></a></div>
                <div class="col-md-8 col-sm-8 testimonial-content">
                    <h3>${sponsor.name!''}</h3>
                    <p>${sponsor.description!''}</p>
                </div>
            </div>
        </div>
        </#list>
    </div>
  </div>
</div>

<#include "footer.ftl">