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
      </#if>
    </div>
  </div>
  <div class="col-sm-8">
    <table style="width:100%">
    <tr>
    <#if LOGO??>
      <td align="left">
        <img src="/file?id=${LOGO}" alt="Logo" >
      </td>
    </#if>
    <#if BANNER??>
      <td align="right">
        ${BANNER}
      </td>
    </#if>
    </tr>
    </table>
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
    <div>
        <div>&nbsp;</div>
        <h3>This Week</h3>
        <div class="agenda">
          <div class="table-responsive">
            <table class="table table-condensed table-bordered">
                <thead>
                    <tr>
                        <th>Date</th>
                        <th>Time</th>
                        <th>Event</th>
                    </tr>
                </thead>
                <tbody>
                    <#list days as day>
                      <tr>
                        <td class="agenda-date" class="active" <#if day.hasEvents()>rowspan="${day.eventsSize}"</#if>>
                            <div class="dayofmonth">${day.day}</div>
                            <div class="dayofweek">${day.dayLabel}</div>
                            <div class="shortdate text-muted">${day.monthLabel}, ${day.yearLabel}</div>
                        </td>
                      <#if !day.hasEvents()>
                        <td class="agenda-time">&nbsp;</td>
                        <td class="agenda-events">
                            <div class="agenda-event">&nbsp;</div>
                        </td>
                      </tr>
                      <#else>
                        <#assign y = 0>
                        <#list day.events as event>
                          <#if y gt 0>
                          <tr>
                            <td class="agenda-time">${event.hour}:${event.paddedMinute} <#if event.pm>PM<#else>AM</#if> <#if event.address?has_content><a href="${event.mapUrl}"><i class="glyphicon  glyphicon-map-marker text-muted"></i></a></#if> <#if event.url?has_content><a href="${event.url}"><i class="glyphicon glyphicon-link text-muted"></i></a></#if></td>
                            <td class="agenda-events">
                              <div class="agenda-event" title="${event.description}">
                                <#if event.weekly><i class="glyphicon glyphicon-repeat text-muted"></i> </#if>${event.name}
                              </div>
                            </td>
                          </tr>
                          <#else>
                            <td class="agenda-time">${event.hour}:${event.paddedMinute} <#if event.pm>PM<#else>AM</#if> <#if event.address?has_content><a href="${event.mapUrl}"><i class="glyphicon  glyphicon-map-marker text-muted"></i></a></#if> <#if event.url?has_content><a href="${event.url}"><i class="glyphicon glyphicon-link text-muted"></i></a></#if></td>
                            <td class="agenda-events">
                              <div class="agenda-event" title="${event.description}">
                                <#if event.weekly><i class="glyphicon glyphicon-repeat text-muted"></i> </#if>${event.name}
                              </div>
                            </td>
                          </tr>
                          </#if>
                          <#assign y++>
                        </#list>
                      </#if>
                    </#list>
                </tbody>
            </table>
        </div>
      </div>
    </div>
  </div>
</div>

<#include "footer.ftl">