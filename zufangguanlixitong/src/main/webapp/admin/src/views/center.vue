<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="80px"
    >  
     <el-row>
                    <el-col :span="12">
           <el-form-item v-if="flag=='zuke'"  label='租客姓名' prop="zukeName">
               <el-input v-model="ruleForm.zukeName"  placeholder='租客姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='zuke'"  label='租客手机号' prop="zukePhone">
               <el-input v-model="ruleForm.zukePhone"  placeholder='租客手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='zuke'"  label='租客身份证号' prop="zukeIdNumber">
               <el-input v-model="ruleForm.zukeIdNumber"  placeholder='租客身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='zuke'" label='租客头像' prop="zukePhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.zukePhoto?ruleForm.zukePhoto:''"
                         @change="zukePhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='zuke'"  label='电子邮箱' prop="zukeEmail">
               <el-input v-model="ruleForm.zukeEmail"  placeholder='电子邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='fangzhu'"  label='房主姓名' prop="fangzhuName">
               <el-input v-model="ruleForm.fangzhuName"  placeholder='房主姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='fangzhu'"  label='房主手机号' prop="fangzhuPhone">
               <el-input v-model="ruleForm.fangzhuPhone"  placeholder='房主手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='fangzhu'"  label='房主身份证号' prop="fangzhuIdNumber">
               <el-input v-model="ruleForm.fangzhuIdNumber"  placeholder='房主身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='fangzhu'" label='房主头像' prop="fangzhuPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.fangzhuPhoto?ruleForm.fangzhuPhoto:''"
                         @change="fangzhuPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='fangzhu'"  label='房主电子邮箱' prop="fangzhuEmail">
               <el-input v-model="ruleForm.fangzhuEmail"  placeholder='房主电子邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='kefu'"  label='客服姓名' prop="kefuName">
               <el-input v-model="ruleForm.kefuName"  placeholder='客服姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='kefu'"  label='客服手机号' prop="kefuPhone">
               <el-input v-model="ruleForm.kefuPhone"  placeholder='客服手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='kefu'"  label='客服身份证号' prop="kefuIdNumber">
               <el-input v-model="ruleForm.kefuIdNumber"  placeholder='客服身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='kefu'" label='客服头像' prop="kefuPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.kefuPhoto?ruleForm.kefuPhoto:''"
                         @change="kefuPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='kefu'"  label='客服电子邮箱' prop="kefuEmail">
               <el-input v-model="ruleForm.kefuEmail"  placeholder='客服电子邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='weixiurenyuan'"  label='维修人员姓名' prop="weixiurenyuanName">
               <el-input v-model="ruleForm.weixiurenyuanName"  placeholder='维修人员姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='weixiurenyuan'"  label='维修人员手机号' prop="weixiurenyuanPhone">
               <el-input v-model="ruleForm.weixiurenyuanPhone"  placeholder='维修人员手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='weixiurenyuan'"  label='维修人员身份证号' prop="weixiurenyuanIdNumber">
               <el-input v-model="ruleForm.weixiurenyuanIdNumber"  placeholder='维修人员身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='weixiurenyuan'" label='维修人员头像' prop="weixiurenyuanPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.weixiurenyuanPhoto?ruleForm.weixiurenyuanPhoto:''"
                         @change="weixiurenyuanPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='weixiurenyuan'"  label='维修人员电子邮箱' prop="weixiurenyuanEmail">
               <el-input v-model="ruleForm.weixiurenyuanEmail"  placeholder='维修人员电子邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-form-item v-if="flag=='users'" label="用户名" prop="username">
             <el-input v-model="ruleForm.username"
                       placeholder="用户名"></el-input>
         </el-form-item>
         <el-col :span="12">
             <el-form-item v-if="flag!='users'"  label="性别" prop="sexTypes">
                 <el-select v-model="ruleForm.sexTypes" placeholder="请选择性别">
                     <el-option
                             v-for="(item,index) in sexTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-col :span="24">
             <el-form-item>
                 <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
             </el-form-item>
         </el-col>
     </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
        ruleForm: {},
        flag: '',
        usersFlag: false,
        // sexTypesOptions : [],
// 注册表 租客
    // 注册的类型字段 租客
        // 性别
        sexTypesOptions : [],
// 注册表 房主
    // 注册的类型字段 房主
        // 性别
        sexTypesOptions : [],
// 注册表 客服
    // 注册的类型字段 客服
        // 性别
        sexTypesOptions : [],
// 注册表 维修人员
    // 注册的类型字段 维修人员
        // 性别
        sexTypesOptions : [],
    };
  },
  mounted() {
    //获取当前登录用户的信息
    var table = this.$storage.get("sessionTable");
    this.sessionTable = this.$storage.get("sessionTable");
    this.role = this.$storage.get("role");
    if (this.role != "管理员"){
    }

    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
// 注册表 租客
// 注册表 房主
// 注册表 客服
// 注册表 维修人员
      } else {
        this.$message.error(data.msg);
      }
    });

// 注册表 租客 的级联表
// 注册表 房主 的级联表
// 注册表 客服 的级联表
// 注册表 维修人员 的级联表

      this.$http({
          url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=sex_types`,
          method: "get"
      }).then(({ data }) => {
          if (data && data.code === 0) {
              this.sexTypesOptions = data.data.list;
          } else {
              this.$message.error(data.msg);
          }
      });
  },
  methods: {
    chongzhi() {
      this.$router.replace({ path: "/pay" });
    },
    zukePhotoUploadChange(fileUrls) {
        this.ruleForm.zukePhoto = fileUrls;
    },
    fangzhuPhotoUploadChange(fileUrls) {
        this.ruleForm.fangzhuPhoto = fileUrls;
    },
    kefuPhotoUploadChange(fileUrls) {
        this.ruleForm.kefuPhoto = fileUrls;
    },
    weixiurenyuanPhotoUploadChange(fileUrls) {
        this.ruleForm.weixiurenyuanPhoto = fileUrls;
    },


    onUpdateHandler() {
                         if((!this.ruleForm.zukeName)&& 'zuke'==this.flag){
                             this.$message.error('租客姓名不能为空');
                             return
                         }

                             if( 'zuke' ==this.flag && this.ruleForm.zukePhone&&(!isMobile(this.ruleForm.zukePhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.zukeIdNumber)&& 'zuke'==this.flag){
                             this.$message.error('租客身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.zukePhoto)&& 'zuke'==this.flag){
                             this.$message.error('租客头像不能为空');
                             return
                         }

                             if( 'zuke' ==this.flag && this.ruleForm.zukeEmail&&(!isEmail(this.ruleForm.zukeEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.fangzhuName)&& 'fangzhu'==this.flag){
                             this.$message.error('房主姓名不能为空');
                             return
                         }

                             if( 'fangzhu' ==this.flag && this.ruleForm.fangzhuPhone&&(!isMobile(this.ruleForm.fangzhuPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.fangzhuIdNumber)&& 'fangzhu'==this.flag){
                             this.$message.error('房主身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.fangzhuPhoto)&& 'fangzhu'==this.flag){
                             this.$message.error('房主头像不能为空');
                             return
                         }

                             if( 'fangzhu' ==this.flag && this.ruleForm.fangzhuEmail&&(!isEmail(this.ruleForm.fangzhuEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.kefuName)&& 'kefu'==this.flag){
                             this.$message.error('客服姓名不能为空');
                             return
                         }

                             if( 'kefu' ==this.flag && this.ruleForm.kefuPhone&&(!isMobile(this.ruleForm.kefuPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.kefuIdNumber)&& 'kefu'==this.flag){
                             this.$message.error('客服身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.kefuPhoto)&& 'kefu'==this.flag){
                             this.$message.error('客服头像不能为空');
                             return
                         }

                             if( 'kefu' ==this.flag && this.ruleForm.kefuEmail&&(!isEmail(this.ruleForm.kefuEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.weixiurenyuanName)&& 'weixiurenyuan'==this.flag){
                             this.$message.error('维修人员姓名不能为空');
                             return
                         }

                             if( 'weixiurenyuan' ==this.flag && this.ruleForm.weixiurenyuanPhone&&(!isMobile(this.ruleForm.weixiurenyuanPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.weixiurenyuanIdNumber)&& 'weixiurenyuan'==this.flag){
                             this.$message.error('维修人员身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.weixiurenyuanPhoto)&& 'weixiurenyuan'==this.flag){
                             this.$message.error('维修人员头像不能为空');
                             return
                         }

                             if( 'weixiurenyuan' ==this.flag && this.ruleForm.weixiurenyuanEmail&&(!isEmail(this.ruleForm.weixiurenyuanEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
        if((!this.ruleForm.sexTypes) && this.flag!='users'){
            this.$message.error('性别不能为空');
            return
        }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
        this.$message.error(`用户名不能为空`);
        return	
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
