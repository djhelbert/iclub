<#include "header.ftl">

<div class="container" style="margin-bottom:10px">
  <div class="row">
    <div class="col-md-12">
        <#list sponsors as sponsor>
		<div class="testiminial-block">
			<div class="row">
				<div class="col-md-2 col-sm-2"><img src="/file?id=${sponsor.binaryFile.id}" alt="Logo" class="img-responsive"/></div>
				<div class="col-md-8 col-sm-8 testimonial-content">
					<h3>${sponsor.name}</h3>
					<p>${sponsor.description}</p>
				</div>
			</div>
		</div>
		</#list>
	</div>
  </div>
</div>

<#include "footer.ftl">