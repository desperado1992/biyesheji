 <div class="section_container">
        <!--Mid Section Starts-->
        <section>
            <!--Banner Starts-->
            <div id="banner_section">
                <div class="flexslider">
                    <ul class="slides">
                        <li> <img src="${ctx}/resources/home/images/lm_banner_1.jpg" />
                            <!--<div class="flex-caption">
                     <h3>Explore the summer collection!</h3>
              </div>-->
                        </li>
                        <li> <img src="${ctx}/resources/home/images/lm_banner_2.jpg" />
                            <!--<div class="flex-caption">
                      <h3>Shop now!</h3>
               </div> -->
                        </li>
                        <li> <img src="${ctx}/resources/home/images/lm_banner_3.jpg" /> </li>
                    </ul>
                </div>
                <div class="promo_banner">
                    <div class="home_banner"><a href="#"><img src="${ctx}/resources/home/images/promo_hb_1.jpg" /></a></div>
                    <div class="home_banner"><a href="#"><img src="${ctx}/resources/home/images/promo_hb_2.jpg" /></a></div>
                    <div class="home_banner"><a href="#"><img src="${ctx}/resources/home/images/promo_hb_3.jpg" /></a></div>
                </div>
            </div>
            <!--Banner Ends-->
            <!--Product List Starts-->
            <div class="products_list products_slider">
                <h2 class="sub_title">新商品</h2>
                <ul id="first-carousel" class="first-and-second-carousel jcarousel-skin-tango">
                   <#list newShops.recordList as newshop>
                    <li> <a class="product_image"><img src="${ctx}/${newshop.image}" /></a>
                        <div class="product_info">
                            <h3><a href="">${newshop.name}</a></h3>
                            <small>${newshop.description}</small> </div>
                        <div class="price_info"> <a href="#">+ 收藏</a>
                            <button class="price_add" title="" type="button"><span class="pr_price">${newshop.price}RMB</span><span class="pr_add">添加到购物车</span></button>
                        </div>
                    </li>
                    </#list>
                </ul>
            </div>
            <!--Product List Ends-->
            <!--Product List Starts-->
            <div class="products_list products_slider">
                <h2 class="sub_title">热销商品</h2>
                <ul id="first-carousel" class="first-and-second-carousel jcarousel-skin-tango">
                 <#list hotShops.recordList as hotshop>
                    <li> <a class="product_image"><img src="${ctx}/${hotshop.image}" /></a>
                        <div class="product_info">
                            <h3><a href="">${hotshop.name}</a></h3>
                            <small>${hotshop.description}</small> </div>
                        <div class="price_info"> <a href="#">+ 收藏</a>
                            <button class="price_add" title="" type="button"><span class="pr_price">${hotshop.price}RMB</span><span class="pr_add">添加到购物车</span></button>
                        </div>
                    </li>
                    </#list>
                </ul>
            </div>
            <!--Product List Ends-->
            <!--Newsletter_subscribe Starts-->
            <div class="subscribe_block">
                <div class="find_us">
                    <h3>Find us on</h3>
                    <a class="twitter" href="#"></a> <a class="facebook" href="#"></a> <a class="rss" href="#"></a> </div>
                <div class="subscribe_nl">
                    <h3>分享订阅</h3>
                    <small>点击分享按钮 分享网站 有一定几率可以返现.</small>
                    <form id="newsletter" method="post" action="#" />
                        <input type="text" class="input-text" value="Enter your email" title="Enter your email" id="newsletter" name="email" />
                        <button class="button" title="" type="submit"></button>
                    </form>
                </div>
            </div>
            <!--Newsletter_subscribe Ends-->
        </section>
        <!--Mid Section Ends-->
    </div>