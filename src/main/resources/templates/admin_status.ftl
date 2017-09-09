<#include "header.ftl">

<div class="container">
      <div class="row">
        <div class="col-md-12">
          <h2>Service Status Page</h2>
        </div>
      </div>
      <div class="row clearfix">
          <div class="col-md-12 column">
              <div class="panel panel-warning">
                <div class="panel-heading">
                  <h3 class="panel-title">
                    <#if database && facebook && smtp>All Systems Operational<#else>Not All Systems Operational</#if> 
                    <small class="pull-right">Refreshed 1s ago</small>
                  </h3>
                </div>
              </div>

              <div class="row clearfix">
                  <div class="col-md-12 column">
                      <div class="list-group">
                          <div class="list-group-item">
                              <h4 class="list-group-item-heading">
                                  Website
                              </h4>
                              <p class="list-group-item-text">
                                  <span class="label label-success">Operational</span>
                              </p>
                          </div>

                          <div class="list-group-item">
                              <h4 class="list-group-item-heading">
                                  Database Connection
                              </h4>
                              <p class="list-group-item-text">
                                  <#if database>
                                    <span class="label label-success">Operational</span>
                                  <#else>
                                    <span class="label label-danger">Not Operational</span>
                                  </#if>
                              </p>
                          </div>

                          <div class="list-group-item">
                              <h4 class="list-group-item-heading">
                                  Facebook API Connection
                              </h4>
                              <p class="list-group-item-text">
                                  <#if facebook>
                                    <span class="label label-success">Operational</span>
                                  <#else>
                                    <span class="label label-danger">Not Operational</span>
                                  </#if>
                              </p>
                          </div>

                          <div class="list-group-item">
                              <h4 class="list-group-item-heading">
                                  Email SMTP Connection
                              </h4>
                              <p class="list-group-item-text">
                                  <#if smtp>
                                    <span class="label label-success">Operational</span>
                                  <#else>
                                    <span class="label label-danger">Not Operational</span>
                                  </#if>
                              </p>
                          </div>
                      </div>
                  </div>
              </div>
          </div>
      </div>
  </div>
  
  <#include "footer.ftl">