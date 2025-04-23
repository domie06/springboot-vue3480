import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import baoxiu from '@/views/modules/baoxiu/list'
    import zuke from '@/views/modules/zuke/list'
    import dictionary from '@/views/modules/dictionary/list'
    import fangwu from '@/views/modules/fangwu/list'
    import fangwuCollection from '@/views/modules/fangwuCollection/list'
    import fangwuLiuyan from '@/views/modules/fangwuLiuyan/list'
    import fangwuOrder from '@/views/modules/fangwuOrder/list'
    import fangzhu from '@/views/modules/fangzhu/list'
    import kefu from '@/views/modules/kefu/list'
    import tousu from '@/views/modules/tousu/list'
    import weixiurenyuan from '@/views/modules/weixiurenyuan/list'
    import zulinhetong from '@/views/modules/zulinhetong/list'
    import config from '@/views/modules/config/list'
    import dictionaryBaoxiu from '@/views/modules/dictionaryBaoxiu/list'
    import dictionaryFangwu from '@/views/modules/dictionaryFangwu/list'
    import dictionaryFangwuCollection from '@/views/modules/dictionaryFangwuCollection/list'
    import dictionaryFangwuOrderYesno from '@/views/modules/dictionaryFangwuOrderYesno/list'
    import dictionaryGuzhang from '@/views/modules/dictionaryGuzhang/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShangxia from '@/views/modules/dictionaryShangxia/list'
    import dictionaryTousu from '@/views/modules/dictionaryTousu/list'
    import dictionaryWeixiuzhuangtai from '@/views/modules/dictionaryWeixiuzhuangtai/list'
    import dictionaryZulinhetong from '@/views/modules/dictionaryZulinhetong/list'
    import dictionaryZulinhetongYesno from '@/views/modules/dictionaryZulinhetongYesno/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryBaoxiu',
        name: '报修物品类型',
        component: dictionaryBaoxiu
    }
    ,{
        path: '/dictionaryFangwu',
        name: '房屋类型',
        component: dictionaryFangwu
    }
    ,{
        path: '/dictionaryFangwuCollection',
        name: '收藏表类型',
        component: dictionaryFangwuCollection
    }
    ,{
        path: '/dictionaryFangwuOrderYesno',
        name: '预约状态',
        component: dictionaryFangwuOrderYesno
    }
    ,{
        path: '/dictionaryGuzhang',
        name: '故障类型',
        component: dictionaryGuzhang
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShangxia',
        name: '上下架',
        component: dictionaryShangxia
    }
    ,{
        path: '/dictionaryTousu',
        name: '投诉类型',
        component: dictionaryTousu
    }
    ,{
        path: '/dictionaryWeixiuzhuangtai',
        name: '维修状态',
        component: dictionaryWeixiuzhuangtai
    }
    ,{
        path: '/dictionaryZulinhetong',
        name: '租赁合同类型',
        component: dictionaryZulinhetong
    }
    ,{
        path: '/dictionaryZulinhetongYesno',
        name: '是否同意',
        component: dictionaryZulinhetongYesno
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/baoxiu',
        name: '报修',
        component: baoxiu
      }
    ,{
        path: '/zuke',
        name: '租客',
        component: zuke
      }
    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/fangwu',
        name: '房屋',
        component: fangwu
      }
    ,{
        path: '/fangwuCollection',
        name: '房屋收藏',
        component: fangwuCollection
      }
    ,{
        path: '/fangwuLiuyan',
        name: '房屋留言',
        component: fangwuLiuyan
      }
    ,{
        path: '/fangwuOrder',
        name: '预约看房',
        component: fangwuOrder
      }
    ,{
        path: '/fangzhu',
        name: '房主',
        component: fangzhu
      }
    ,{
        path: '/kefu',
        name: '客服',
        component: kefu
      }
    ,{
        path: '/tousu',
        name: '投诉',
        component: tousu
      }
    ,{
        path: '/weixiurenyuan',
        name: '维修人员',
        component: weixiurenyuan
      }
    ,{
        path: '/zulinhetong',
        name: '租赁合同',
        component: zulinhetong
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
