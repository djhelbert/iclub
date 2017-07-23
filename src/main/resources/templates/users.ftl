<#include "header.ftl">

        <div class="section">
            <div class="container">
                <ul class="breadcrumb">
                  <li>Admin</li>
                  <li class="active">Users</li>
                </ul>
                <div class="row">
                    <div class="col-md-12">
                        <table class="table table-hover table-striped">
                            <tbody>
                                <#list users as user>
                                <tr>
                                    <td>
                                        <img src="/static/user_placeholder.png" class="img-circle" width="60">
                                    </td>
                                    <td>
                                        <h4><b>${user.firstName!''} ${user.lastName!''}</b></h4>
                                        <p><a href="mailto:${user.email!''}">${user.email!''}</a></p>
                                    </td>
                                    <td>
                                        <p>${user.homePhone!''}</p>
                                        <p>${user.cellPhone!''}</p>
                                    </td>
                                    <td><p>${user.role!''}</p><p>&nbsp;</p></td>
                                    <td>
                                        <div class="btn-group">
                                            <#if !user.admin >
                                            <button class="btn btn-default" value="left" type="button" onclick="window.location.href='/admin/users/delete?id=${user.id}'"><i class="fa fa-fw s fa-remove"></i>Delete</button>
                                            </#if>
                                            <button class="btn btn-default" value="right" type="button"><i class="fa fa-fw fa-cog"></i>Edit</button>
                                        </div>
                                    </td>
                                </tr>
                                </#list>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

<#include "footer.ftl">