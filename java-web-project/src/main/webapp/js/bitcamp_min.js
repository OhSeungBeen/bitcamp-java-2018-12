var Bitcamp=function(a){var b=[];if(a instanceof HTMLElement)b.push(a);else if(a.startsWith("<")){var c=a.substr(1,a.length-2);b.push(document.createElement(c))}else{var d=document.querySelectorAll(a);for(var f of d)b.push(f)}return b.html=function(a){if(0<arguments.length){for(var b of this)b.innerHTML=a;return this}return this[0].innerHTML},b.addClass=function(a){for(var b of this){var c=a,d=b.className.split(" ");for(var e of d)c=c+" "+e;b.className=c}return this},b.removeClass=function(a){for(var b of this){var c="",d=b.className.split(" ");for(var e of d)e!=a&&(c=c+" "+e);b.className=c}return this},b.click=function(a){for(var b of this)b.addEventListener("click",a);return this},b.bind=function(a,c){for(var d of b)d.addEventListener(a,c);return this},b.attr=function(a,b){if(1==arguments.length)return this[0].getAttribute(a);for(var c of this)c.setAttribute(a,b);return this},b.trigger=function(a){for(var b of this)b.dispatchEvent(new Event(a));return this},b.append=function(a){for(var b of this)for(var c of a)b.appendChild(c);return this},b.appendTo=function(a){for(var b of a)for(var c of this)b.appendChild(c);return this},b};Bitcamp.ajax=function(a,b){(b==null||null==b)&&(b={}),b.method||(b.method="GET"),b.dataType||(b.dataType="text");var c=new XMLHttpRequest;c.onreadystatechange=function(){return 4==c.readyState?200==c.status?void(b.success&&("json"==b.dataType?b.success(JSON.parse(c.responseText)):b.success(c.responseText))):void(b.error&&b.error()):void 0},c.open(b.method,a,!0),c.send()},Bitcamp.getJSON=function(a,b){Bitcamp.ajax(a,{dataType:"json",success:b})};var $=Bitcamp;