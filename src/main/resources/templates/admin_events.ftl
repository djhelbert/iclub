<#include "header.ftl">

<#if message??>
<div class="container" style="margin-bottom:5px">
  <div class="alert alert-success">
    ${message}
  </div>
</div>
</#if>

<div class="container" style="margin-bottom:10px">
  <ul class="breadcrumb">
    <li>Admin</li>
    <li class="active">Weekly Events</li>
  </ul>
  <div>
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
                            <div class="shortdate text-muted">${day.monthLabel}, ${day.year}</div>
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
                          <#if y > 0>
                          <tr>
                            <td class="agenda-time">${event.hour}:${event.minute}</td>
                            <td class="agenda-events">
                              <div class="agenda-event">
                                ${event.name}
                              </div>
                            </td>
                          </tr>
                          <#else>
                            <td class="agenda-time">${event.hour}:${event.minute}</td>
                            <td class="agenda-events">
                              <div class="agenda-event">
                                ${event.name}
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

<#include "footer.ftl">