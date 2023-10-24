<%@ page import="com.highradius.service.WishMessageService"%>
<h1>
	<%= new WishMessageService().getWishMessage("jayakumar") %>
</h1>