(global["webpackJsonp"]=global["webpackJsonp"]||[]).push([["pages/forum-detail/forum-detail"],{"21f7":function(t,n,e){"use strict";var r=e("a753"),a=e.n(r);a.a},a5dd:function(t,n,e){"use strict";e.r(n);var r=e("acf5"),a=e("b317");for(var u in a)"default"!==u&&function(t){e.d(n,t,(function(){return a[t]}))}(u);e("21f7");var o,c=e("f0c5"),i=Object(c["a"])(a["default"],r["b"],r["c"],!1,null,"444c0513",null,!1,r["a"],o);n["default"]=i.exports},a753:function(t,n,e){},acf5:function(t,n,e){"use strict";var r;e.d(n,"b",(function(){return a})),e.d(n,"c",(function(){return u})),e.d(n,"a",(function(){return r}));var a=function(){var t=this,n=t.$createElement;t._self._c},u=[]},b317:function(t,n,e){"use strict";e.r(n);var r=e("b6d1"),a=e.n(r);for(var u in r)"default"!==u&&function(t){e.d(n,t,(function(){return r[t]}))}(u);n["default"]=a.a},b6d1:function(t,n,e){"use strict";Object.defineProperty(n,"__esModule",{value:!0}),n.default=void 0;var r=a(e("a34a"));function a(t){return t&&t.__esModule?t:{default:t}}function u(t,n,e,r,a,u,o){try{var c=t[u](o),i=c.value}catch(f){return void e(f)}c.done?n(i):Promise.resolve(i).then(r,a)}function o(t){return function(){var n=this,e=arguments;return new Promise((function(r,a){var o=t.apply(n,e);function c(t){u(o,r,a,c,i,"next",t)}function i(t){u(o,r,a,c,i,"throw",t)}c(void 0)}))}}var c=function(){e.e("components/forum-reply/forum-reply").then(function(){return resolve(e("886e"))}.bind(null,e)).catch(e.oe)},i={components:{userReply:c},data:function(){return{commentData:[],forum:{},id:""}},onLoad:function(t){var n=this;return o(r.default.mark((function e(){var a;return r.default.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return n.id=t.id,e.next=3,n.$api.forumDetail(t.id);case 3:a=e.sent,n.commentData=a.data.childs,n.forum=a.data,console.log(n.commentData);case 7:case"end":return e.stop()}}),e)})))()},onShow:function(){var t=this;return o(r.default.mark((function n(){var e;return r.default.wrap((function(n){while(1)switch(n.prev=n.next){case 0:return n.next=2,t.$api.forumDetail(t.id);case 2:e=n.sent,t.commentData=e.data.childs,t.forum=e.data;case 5:case"end":return n.stop()}}),n)})))()},methods:{onReplyTap:function(t){this.$utils.jump("../forum-reply/forum-reply?pid=".concat(t))}}};n.default=i},d32c:function(t,n,e){"use strict";(function(t){e("0eba");r(e("66fd"));var n=r(e("a5dd"));function r(t){return t&&t.__esModule?t:{default:t}}t(n.default)}).call(this,e("543d")["createPage"])}},[["d32c","common/runtime","common/vendor"]]]);