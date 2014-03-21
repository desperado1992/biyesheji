    <div class="navigation_container">
        <!--Navigation Starts-->
        <nav>
    <ul class="primary_nav">
    <#list channels as channel>
    <li>
   <a href="${channel.link_url}">${channel.name}</a>
   <#if channel.childrens??>
 <ul class="sub_menu">
   <#list channel.childrens as child1>
   <li>
	  <a href="${child1.link_url}">${child1.name}</a>
	  <#if child1.childrens??>
	  <ul>
	   <#list child1.childrens as child2>
	   <li><a href="${child2.link_url}">${child2.name}</a></li>
	   </#list>
	   </ul>
	   <#else>
	   
	   </#if>
    </li>
    </#list>
    </ul>	
   <#else>
   
    </#if>
    </li>
    </#list>
    </ul>
            <div class="minicart"> <a href="#" class="minicart_link"> <span class="item"><b>2</b> ITEM /</span> <span class="price"><b>$69.20</b></span> </a>
                <div class="cart_drop"> <span class="darw"></span>
                    <ul>
                        <li><img src="/resources/home/images/mini_c_item1.png" /><a href="#">Clogs Beach/Garden Clog</a> <span class="price">$49.90</span></li>
                        <li><img src="/resources/home/images/mini_c_item2.png" /><a href="#">Faded chambray shorts</a> <span class="price">$12.90</span></li>
                        <div class="cart_bottom">
                            <div class="subtotal_menu"><small>Subtotal:</small><big>$69.20</big></div>
                            <a href="leisure_cart.html">Checkout</a></div>
                    </ul>
                </div>
            </div>
        </nav>
        <!--Navigation Ends-->
    </div>