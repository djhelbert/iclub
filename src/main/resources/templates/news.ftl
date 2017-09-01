<#include "header.ftl">

<#list posts as post>
<div class="container">
    <div class="col-md-6">
        <div class="panel panel-default">
            <div class="panel-body">
               <section class="post-heading">
                    <div class="row">
                        <div class="col-md-11">
                            <div class="media">
                              <div class="media-left">
                                <a href="${user.link}">
                                  <img class="media-object photo-profile" src="${user.getPicture().getURL()}" width="40" height="40">
                                </a>
                              </div>
                              <div class="media-body">
                                <a href="<#if post.link??>${post.link}</#if>" class="anchor-username"><h4 class="media-heading"><#if post.name??>${post.name}</#if> </h4></a>
                                <a href="<#if post.link??>${post.link}</#if>" class="anchor-time">${post.createdTime?date} </a>
                              </div>
                            </div>
                        </div>
                        <div class="col-md-1">
                            <a href="#"><i class="glyphicon glyphicon-chevron-down"></i></a>
                        </div>
                    </div>
               </section>
               <section class="post-body">
                   <#if post.message??><p>${post.message}</p></#if>
                   <#if post.story??><p>${post.story}</p></#if>
                   <#if post.fullPicture??><img class="media-object photo-profile" width="450" src="${post.fullPicture}"></#if>
               </section>
               <section class="post-footer">
                   <hr>
                   <div class="post-footer-option container">
                        <ul class="list-unstyled">
                            <li><a href="<#if post.permalinkUrl??>${post.permalinkUrl}</#if>"><i class="glyphicon glyphicon-link"></i> Link</a></li>
                            <li><div class="g-plus" data-action="share"></div></li>
                            <li><a href="https://twitter.com/share" <#if post.permalinkUrl??>data-url="${post.permalinkUrl}"</#if> class="twitter-share-button" data-show-count="false">Tweet</a><script async src="//platform.twitter.com/widgets.js" charset="utf-8"></script>
                        </ul>
                   </div>
               </section>
            </div>
        </div>
    </div>
</div>
</#list>

<#include "footer.ftl">