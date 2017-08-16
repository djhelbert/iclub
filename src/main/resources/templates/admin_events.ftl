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
                                <#if event.weekly><i class="glyphicon glyphicon-repeat text-muted"></i> </#if>${event.name} <a href="/admin/events/weekly/delete?id=${event.id}"><i class="glyphicon glyphicon-remove text-muted"></i></a>
                              </div>
                            </td>
                          </tr>
                          <#else>
                            <td class="agenda-time">${event.hour}:${event.paddedMinute} <#if event.pm>PM<#else>AM</#if> <#if event.address?has_content><a href="${event.mapUrl}"><i class="glyphicon  glyphicon-map-marker text-muted"></i></a></#if> <#if event.url?has_content><a href="${event.url}"><i class="glyphicon glyphicon-link text-muted"></i></a></#if></td>
                            <td class="agenda-events">
                              <div class="agenda-event" title="${event.description}">
                                <#if event.weekly><i class="glyphicon glyphicon-repeat text-muted"></i> </#if>${event.name} <a href="/admin/events/weekly/delete?id=${event.id}"><i class="glyphicon glyphicon-remove text-muted"></i></a>
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

<form class="form-horizontal" action="/admin/events" method="POST">

<div class="container" style="margin-bottom:10px">
<h3>Add Weekly Event</h3>
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  <div class="form-group">
    <label class="control-label col-sm-2" for="name">Name *</label>
    <div class="col-sm-10">
      <input type="input" class="form-control" maxlength="50" name="name" id="name" placeholder="" required>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="description">Description</label>
    <div class="col-sm-10"> 
      <input type="input" class="form-control" maxlength="250" name="description" id="description" placeholder="">
    </div>
  </div>
    <div class="form-group">
    <label class="control-label col-sm-2" for="url">URL</label>
    <div class="col-sm-10">
      <input type="url" class="form-control" maxlength="250" name="url" id="url" placeholder="">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="address">Address</label>
    <div class="col-sm-10">
      <input type="input" class="form-control" maxlength="250" name="address" id="address" placeholder="">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="dayOfWeek">Day Of Week</label>
    <div class="col-sm-10">
      <select id="dayOfWeek" name="dayOfWeek" class="form-control" required>
        <option value="1">Sunday</option>
        <option value="2">Monday</option>
        <option value="3">Tuesday</option>
        <option value="4">Wednesday</option>
        <option value="5">Thursday</option>
        <option value="6">Friday</option>
        <option value="7">Saturday</option>
      </select>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="time">Time</label>
    <div class="col-sm-10">
      <input type="time" class="form-control" name="time" id="time" placeholder="" required>
    </div>
  </div>
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Submit</button>
    </div>
  </div>
</div>

</form>

<div class="container" style="margin-bottom:10px">
  <ul class="breadcrumb">
    <li>Admin</li>
    <li class="active">Events</li>
  </ul>
  <div>
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
                    <#list events as day>
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
                                ${event.name} <a href="/admin/events/delete?id=${event.id}"><i class="glyphicon glyphicon-remove text-muted"></i></a>
                              </div>
                            </td>
                          </tr>
                          <#else>
                            <td class="agenda-time">${event.hour}:${event.paddedMinute} <#if event.pm>PM<#else>AM</#if> <#if event.address?has_content><a href="${event.mapUrl}"><i class="glyphicon  glyphicon-map-marker text-muted"></i></a></#if> <#if event.url?has_content><a href="${event.url}"><i class="glyphicon glyphicon-link text-muted"></i></a></#if></td>
                            <td class="agenda-events">
                              <div class="agenda-event" title="${event.description}">
                                ${event.name} <a href="/admin/events/delete?id=${event.id}"><i class="glyphicon glyphicon-remove text-muted"></i></a>
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

<form class="form-horizontal" action="/admin/events" method="POST">

<div class="container" style="margin-bottom:10px">
<h3>Add Event</h3>
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  <div class="form-group">
    <label class="control-label col-sm-2" for="name">Name *</label>
    <div class="col-sm-10">
      <input type="input" class="form-control" maxlength="50" name="name" id="name" placeholder="" required>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="description">Description</label>
    <div class="col-sm-10"> 
      <input type="input" class="form-control" maxlength="250" name="description" id="description" placeholder="">
    </div>
  </div>
    <div class="form-group">
    <label class="control-label col-sm-2" for="url">URL</label>
    <div class="col-sm-10">
      <input type="url" class="form-control" maxlength="250" name="url" id="url" placeholder="">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="address">Address</label>
    <div class="col-sm-10">
      <input type="input" class="form-control" maxlength="250" name="address" id="address" placeholder="">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="date">Date</label>
    <div class="col-sm-10">
      <input type="date" class="form-control" name="date" id="date" placeholder="" required>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="time">Time</label>
    <div class="col-sm-10">
      <input type="time" class="form-control" name="time" id="time" placeholder="" required>
    </div>
  </div>
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Submit</button>
    </div>
  </div>
</div>

</form>

<#include "footer.ftl">