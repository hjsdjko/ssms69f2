const menu = {
    list() {
        return [{"backMenu":[{"child":[{"buttons":["查看","删除"],"menu":"用户","menuJump":"列表","tableName":"yonghu"}],"menu":"用户管理"},{"child":[{"buttons":["新增","查看","修改","删除","查看评论"],"menu":"学习天地","menuJump":"列表","tableName":"xuexitiandi"}],"menu":"学习天地管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"书籍分类","menuJump":"列表","tableName":"shujifenlei"}],"menu":"书籍分类管理"},{"child":[{"buttons":["查看","删除"],"menu":"学习签到","menuJump":"列表","tableName":"xuexiqiandao"}],"menu":"学习签到管理"},{"child":[{"buttons":["查看","修改","回复","删除"],"menu":"留言板管理","tableName":"messages"}],"menu":"留言板管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"交流论坛","tableName":"forum"}],"menu":"交流论坛"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"关于我们","tableName":"news"},{"buttons":["查看","修改"],"menu":"轮播图管理","tableName":"config"}],"menu":"系统管理"},{"child":[{"buttons":["查看","删除"],"menu":"已发货订单","tableName":"orders/已发货"},{"buttons":["查看","删除"],"menu":"未支付订单","tableName":"orders/未支付"},{"buttons":["查看","删除"],"menu":"已取消订单","tableName":"orders/已取消"},{"buttons":["查看","删除","发货"],"menu":"已支付订单","tableName":"orders/已支付"},{"buttons":["查看","删除"],"menu":"已退款订单","tableName":"orders/已退款"},{"buttons":["查看","删除"],"menu":"已完成订单","tableName":"orders/已完成"}],"menu":"订单管理"}],"frontMenu":[{"child":[{"buttons":["查看"],"menu":"学习天地列表","menuJump":"列表","tableName":"xuexitiandi"}],"menu":"学习天地模块"},{"child":[{"buttons":["查看"],"menu":"学习签到列表","menuJump":"列表","tableName":"xuexiqiandao"}],"menu":"学习签到模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"学习签到","menuJump":"列表","tableName":"xuexiqiandao"}],"menu":"学习签到管理"},{"child":[{"buttons":["查看","删除"],"menu":"我的收藏管理","tableName":"storeup"}],"menu":"我的收藏管理"}],"frontMenu":[{"child":[{"buttons":["查看"],"menu":"学习天地列表","menuJump":"列表","tableName":"xuexitiandi"}],"menu":"学习天地模块"},{"child":[{"buttons":["查看"],"menu":"学习签到列表","menuJump":"列表","tableName":"xuexiqiandao"}],"menu":"学习签到模块"}],"hasBackLogin":"否","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"用户","tableName":"yonghu"}]
    }
}
export default menu;