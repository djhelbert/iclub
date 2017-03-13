<#include "header.ftl">

<div class="container">

<div class="row">
  <div class="col-sm-4">
    <div>
      <a class="twitter-timeline" data-lang="en" data-width="300" data-height="454" data-dnt="true" href="https://twitter.com/onemultisport">Tweets by fabric</a> <script async src="http://platform.twitter.com/widgets.js" charset="utf-8"></script>
    </div>
    <div>
      <iframe height='454' width='300' frameborder='0' allowtransparency='true' scrolling='no' src='https://www.strava.com/clubs/80067/latest-rides/1aad5fa871e1c40c03e99501bdc41a5d974c410e?show_rides=true'></iframe>
    </div>
  </div>
  <div class="col-sm-8">
    <div>
      <img src="http://www.onemultisport.com/wp-content/uploads/2011/05/vol-one-teer.jpg" class="img-rounded" alt="Cinque Terre" >
    </div>
    <div>&nbsp;</div>
    <div>
      ${DESCRIPTION}
    </div>
    <div>&nbsp;</div>
    <div id="myCarousel" class="carousel slide" data-ride="carousel">

    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
       <div class="item active">
         <img src="http://lavamagazine.com/wp-content/blogs.dir/2/files/2011/09/10-23-rumonmaui2.jpg" alt="First">
         <div class="carousel-caption">
           <h3>Runners</h3>
           <p>We are simply the best.</p>
         </div>
       </div>

       <div class="item">
         <img src="http://www.xterraplanet.com/wp-content/uploads/DSC_0400-001.jpg" alt="Second">
       </div>

       <div class="item">
         <img src="https://lisamulch.files.wordpress.com/2010/10/img_56751.jpg" alt="Third">
       </div>

       <div class="item">
         <img src="http://d279m997dpfwgl.cloudfront.net/wp/2016/04/runners.jpg" alt="Fourth">
       </div>
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