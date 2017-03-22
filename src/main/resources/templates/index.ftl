<#include "header.ftl">

<div class="container">
<div class="row">
  <div class="col-sm-4">
    <div>
      <a class="twitter-timeline" data-lang="en" data-width="300" data-height="454" data-dnt="true" href="https://twitter.com/${TWITTER}">Tweets</a> <script async src="http://platform.twitter.com/widgets.js" charset="utf-8"></script>
    </div>
    <div>
    <#if STRAVA??>
      ${STRAVA}
    </div>
    </#if>
  </div>
  <div class="col-sm-8">
    <#if LOGO??>
    <div>
      <img src="/file?id=${LOGO}" alt="Logo" >
    </div>
    </#if>
    <div>&nbsp;</div>
    <div>
      ${DESCRIPTION}
    </div>
    <div>&nbsp;</div>
    <div id="myCarousel" class="carousel slide" data-ride="carousel">

    <!-- Indicators -->
    <ol class="carousel-indicators">
      <#if SCROLLERS??>
         <#assign x=0>
         <#list SCROLLERS as scroller>
           <li data-target="#myCarousel" data-slide-to="${x}" <#if x=1>class="active"></#if></li>
           <#assign x++>
         </#list>
       </#if>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
       <#if SCROLLERS??>
         <#assign x=0>
         <#list SCROLLERS as scrollerId>
           <div class="item <#if x=1>active</#if>">
             <img src="/file?id=${scrollerId}" alt="Scroller Image">
           </div>
           <#assign x++>
         </#list>
       </#if>
     </div>

     <!-- Left and right controls -->
     <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
       <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
       <span class="sr-only">Previous</span>
     </a>
     <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
       <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
       <span class="sr-only">Next</span>
    </a>
    </div>
  </div>
</div>
</div>

<#include "footer.ftl">