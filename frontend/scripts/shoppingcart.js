function getCookie(cookieName) {
	const cookies = document.cookie.split(';');
	for (let i = 0; i < cookies.length; i++) {
		let cookie = cookies[i].trim();
		if (cookie.startsWith(cookieName + '=')) {
			return cookie.substring(cookieName.length + 1);
		}
	}
	return null;
}

function getCartItems() {
	let value = getCookie("cartItems");
	if (value !== null) {
		value = value.replace(/\+/g, '%20');
		return JSON.parse(decodeURIComponent(value))["items"];
	}
	return [];
}

function getTotal() {
	let value = getCookie("cartItems");
	if (value !== null) {
		value = value.replace(/\+/g, '%20');
		return JSON.parse(decodeURIComponent(value))["total"];
	}
 	return 0;
}