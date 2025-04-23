<template>
    <div class="addEdit-block">
        <el-form
                class="detail-form-content"
                ref="ruleForm"
                :model="ruleForm"
                :rules="rules"
                label-width="auto"
                :style="{backgroundColor:addEditForm.addEditBoxColor}">
            <el-row>
                <el-col :span="12"  v-if="sessionTable !='zuke'">
                    <el-form-item class="select" v-if="type!='info'"  label="租客" prop="zukeId">
                        <el-select v-model="ruleForm.zukeId" :disabled="ro.zukeId" filterable placeholder="请选择租客" @change="zukeChange">
                            <el-option
                                    v-for="(item,index) in zukeOptions"
                                    v-bind:key="item.id"
                                    :label="item.zukeName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='zuke' ">
                    <el-form-item class="input" v-if="type!='info'"  label="租客姓名" prop="zukeName">
                        <el-input v-model="zukeForm.zukeName"
                                  placeholder="租客姓名" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="租客姓名" prop="zukeName">
                            <el-input v-model="ruleForm.zukeName"
                                      placeholder="租客姓名" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='zuke' ">
                    <el-form-item class="input" v-if="type!='info'"  label="租客手机号" prop="zukePhone">
                        <el-input v-model="zukeForm.zukePhone"
                                  placeholder="租客手机号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="租客手机号" prop="zukePhone">
                            <el-input v-model="ruleForm.zukePhone"
                                      placeholder="租客手机号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='zuke' ">
                    <el-form-item class="input" v-if="type!='info'"  label="租客身份证号" prop="zukeIdNumber">
                        <el-input v-model="zukeForm.zukeIdNumber"
                                  placeholder="租客身份证号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="租客身份证号" prop="zukeIdNumber">
                            <el-input v-model="ruleForm.zukeIdNumber"
                                      placeholder="租客身份证号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="sessionTable !='zuke' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.zukePhoto" label="租客头像" prop="zukePhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (zukeForm.zukePhoto || '').split(',')" :src="item" width="100" height="100">
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.zukePhoto" label="租客头像" prop="zukePhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.zukePhoto || '').split(',')" :src="item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='zuke' ">
                    <el-form-item class="input" v-if="type!='info'"  label="电子邮箱" prop="zukeEmail">
                        <el-input v-model="zukeForm.zukeEmail"
                                  placeholder="电子邮箱" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="电子邮箱" prop="zukeEmail">
                            <el-input v-model="ruleForm.zukeEmail"
                                      placeholder="电子邮箱" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='fangzhu'">
                    <el-form-item class="select" v-if="type!='info'"  label="房主" prop="fangzhuId">
                        <el-select v-model="ruleForm.fangzhuId" :disabled="ro.fangzhuId" filterable placeholder="请选择房主" @change="fangzhuChange">
                            <el-option
                                    v-for="(item,index) in fangzhuOptions"
                                    v-bind:key="item.id"
                                    :label="item.fangzhuName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='fangzhu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="房主姓名" prop="fangzhuName">
                        <el-input v-model="fangzhuForm.fangzhuName"
                                  placeholder="房主姓名" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="房主姓名" prop="fangzhuName">
                            <el-input v-model="ruleForm.fangzhuName"
                                      placeholder="房主姓名" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='fangzhu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="房主手机号" prop="fangzhuPhone">
                        <el-input v-model="fangzhuForm.fangzhuPhone"
                                  placeholder="房主手机号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="房主手机号" prop="fangzhuPhone">
                            <el-input v-model="ruleForm.fangzhuPhone"
                                      placeholder="房主手机号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='fangzhu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="房主身份证号" prop="fangzhuIdNumber">
                        <el-input v-model="fangzhuForm.fangzhuIdNumber"
                                  placeholder="房主身份证号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="房主身份证号" prop="fangzhuIdNumber">
                            <el-input v-model="ruleForm.fangzhuIdNumber"
                                      placeholder="房主身份证号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="sessionTable !='fangzhu' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.fangzhuPhoto" label="房主头像" prop="fangzhuPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (fangzhuForm.fangzhuPhoto || '').split(',')" :src="item" width="100" height="100">
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.fangzhuPhoto" label="房主头像" prop="fangzhuPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.fangzhuPhoto || '').split(',')" :src="item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='fangzhu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="房主电子邮箱" prop="fangzhuEmail">
                        <el-input v-model="fangzhuForm.fangzhuEmail"
                                  placeholder="房主电子邮箱" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="房主电子邮箱" prop="fangzhuEmail">
                            <el-input v-model="ruleForm.fangzhuEmail"
                                      placeholder="房主电子邮箱" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <input id="updateId" name="id" type="hidden">
            <input id="fangzhuId" name="fangzhuId" type="hidden">
            <input id="zukeId" name="zukeId" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="租赁合同编号" prop="zulinhetongUuidNumber">
                       <el-input v-model="ruleForm.zulinhetongUuidNumber"
                                 placeholder="租赁合同编号" clearable  :readonly="ro.zulinhetongUuidNumber"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="租赁合同编号" prop="zulinhetongUuidNumber">
                           <el-input v-model="ruleForm.zulinhetongUuidNumber"
                                     placeholder="租赁合同编号" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="租赁合同名称" prop="zulinhetongName">
                       <el-input v-model="ruleForm.zulinhetongName"
                                 placeholder="租赁合同名称" clearable  :readonly="ro.zulinhetongName"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="租赁合同名称" prop="zulinhetongName">
                           <el-input v-model="ruleForm.zulinhetongName"
                                     placeholder="租赁合同名称" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="upload" v-if="type!='info' && !ro.zulinhetongFile" label="租赁合同文件" prop="zulinhetongFile">
                        <file-upload
                                tip="点击上传租赁合同文件"
                                action="file/upload"
                                :limit="3"
                                :multiple="true"
                                :fileUrls="ruleForm.zulinhetongFile?ruleForm.zulinhetongFile:''"
                                @change="zulinhetongFileUploadChange"
                        ></file-upload>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.zulinhetongFile" label="租赁合同文件" prop="zulinhetongFile">
                            <a type="text" style="text-decoration:none" class="el-button" :href="ruleForm.zulinhetongFile"  >租赁合同文件下载</a>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="租赁合同类型" prop="zulinhetongTypes">
                        <el-select v-model="ruleForm.zulinhetongTypes" :disabled="ro.zulinhetongTypes" placeholder="请选择租赁合同类型">
                            <el-option
                                v-for="(item,index) in zulinhetongTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="租赁合同类型" prop="zulinhetongValue">
                        <el-input v-model="ruleForm.zulinhetongValue"
                            placeholder="租赁合同类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item v-if="type!='info'"  class="input" label="租赁日期" prop="zulinriqiTime">
                        <el-date-picker
                                value-format="yyyy-MM-dd HH:mm:ss"
                                v-model="ruleForm.zulinriqiTime"
                                type="datetime"
                                placeholder="租赁日期"
                                :disabled="ro.zulinriqiTime">
                        </el-date-picker>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.zulinriqiTime" label="租赁日期" prop="zulinriqiTime">
                            <span v-html="ruleForm.zulinriqiTime"></span>
                        </el-form-item>
                    </div>
                </el-col>

               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="租赁月" prop="zulinhetongYue">
                       <el-input v-model="ruleForm.zulinhetongYue"
                                 placeholder="租赁月" clearable  :readonly="ro.zulinhetongYue"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="租赁月" prop="zulinhetongYue">
                           <el-input v-model="ruleForm.zulinhetongYue"
                                     placeholder="租赁月" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="押金" prop="zulinhetongYajinJine">
                       <el-input v-model="ruleForm.zulinhetongYajinJine"
                                 placeholder="押金" clearable  :readonly="ro.zulinhetongYajinJine"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="押金" prop="zulinhetongYajinJine">
                           <el-input v-model="ruleForm.zulinhetongYajinJine"
                                     placeholder="押金" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="每月金额" prop="zulinhetongJine">
                       <el-input v-model="ruleForm.zulinhetongJine"
                                 placeholder="每月金额" clearable  :readonly="ro.zulinhetongJine"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="每月金额" prop="zulinhetongJine">
                           <el-input v-model="ruleForm.zulinhetongJine"
                                     placeholder="每月金额" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="24">
                    <el-form-item v-if="type!='info'"  label="合同备注" prop="zulinhetongContent">
                        <editor style="min-width: 200px; max-width: 600px;"
                                v-model="ruleForm.zulinhetongContent"
                                class="editor"
                                action="file/upload">
                        </editor>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.zulinhetongContent" label="合同备注" prop="zulinhetongContent">
                            <span v-html="ruleForm.zulinhetongContent"></span>
                        </el-form-item>
                    </div>
                </el-col>
            <el-col :span="12" v-if="type=='info'">
                <div>
                    <el-form-item v-if="ruleForm.zulinhetongYesnoTypes" label="是否同意" prop="zulinhetongYesnoTypes">
                        <el-input v-model="ruleForm.zulinhetongYesnoValue" placeholder="是否同意" readonly></el-input>
                    </el-form-item>
                </div>
            </el-col>
            </el-row>
            <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
                <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
                <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
    import styleJs from "../../../utils/style.js";
    // 数字，邮件，手机，url，身份证校验
    import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
    export default {
        data() {
            return {
                addEditForm:null,
                id: '',
                type: '',
                sessionTable : "",//登录账户所在表名
                role : "",//权限
                userId:"",//当前登录人的id
                zukeForm: {},
                fangzhuForm: {},
                ro:{
                    fangzhuId: false,
                    zukeId: false,
                    zulinhetongUuidNumber: false,
                    zulinhetongName: false,
                    zulinhetongFile: false,
                    zulinhetongTypes: false,
                    zulinriqiTime: false,
                    zulinhetongYue: false,
                    zulinhetongYajinJine: false,
                    zulinhetongJine: false,
                    zulinhetongContent: false,
                    zulinhetongYesnoTypes: false,
                    insertTime: false,
                },
                ruleForm: {
                    fangzhuId: '',
                    zukeId: '',
                    zulinhetongUuidNumber: new Date().getTime(),
                    zulinhetongName: '',
                    zulinhetongFile: '',
                    zulinhetongTypes: '',
                    zulinriqiTime: '',
                    zulinhetongYue: '',
                    zulinhetongYajinJine: '',
                    zulinhetongJine: '',
                    zulinhetongContent: '',
                    zulinhetongYesnoTypes: '',
                    insertTime: '',
                },
                zulinhetongTypesOptions : [],
                zulinhetongYesnoTypesOptions : [],
                zukeOptions : [],
                fangzhuOptions : [],
                rules: {
                   fangzhuId: [
                              { required: true, message: '房主不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   zukeId: [
                              { required: true, message: '租客不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   zulinhetongUuidNumber: [
                              { required: true, message: '租赁合同编号不能为空', trigger: 'blur' },
                          ],
                   zulinhetongName: [
                              { required: true, message: '租赁合同名称不能为空', trigger: 'blur' },
                          ],
                   zulinhetongFile: [
                              { required: true, message: '租赁合同文件不能为空', trigger: 'blur' },
                          ],
                   zulinhetongTypes: [
                              { required: true, message: '租赁合同类型不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   zulinriqiTime: [
                              { required: true, message: '租赁日期不能为空', trigger: 'blur' },
                          ],
                   zulinhetongYue: [
                              { required: true, message: '租赁月不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   zulinhetongYajinJine: [
                              { required: true, message: '押金不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]{0,6}(\.[0-9]{1,2})?$/,
                                  message: '只允许输入整数6位,小数2位的数字',
                                  trigger: 'blur'
                              }
                          ],
                   zulinhetongJine: [
                              { required: true, message: '每月金额不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]{0,6}(\.[0-9]{1,2})?$/,
                                  message: '只允许输入整数6位,小数2位的数字',
                                  trigger: 'blur'
                              }
                          ],
                   zulinhetongContent: [
                              { required: true, message: '合同备注不能为空', trigger: 'blur' },
                          ],
                   zulinhetongYesnoTypes: [
                              { required: true, message: '是否同意不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   insertTime: [
                              { required: true, message: '记录时间不能为空', trigger: 'blur' },
                          ],
                }
            };
        },
        props: ["parent"],
        computed: {
        },
        created() {
            //获取当前登录用户的信息
            this.sessionTable = this.$storage.get("sessionTable");
            this.role = this.$storage.get("role");
            this.userId = this.$storage.get("userId");


            if (this.role != "管理员"){
            }
            this.addEditForm = styleJs.addStyle();
            this.addEditStyleChange()
            this.addEditUploadStyleChange()
            //获取下拉框信息
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=zulinhetong_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.zulinhetongTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=zulinhetong_yesno_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.zulinhetongYesnoTypesOptions = data.data.list;
                    }
                });

         this.$http({
             url: `zuke/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.zukeOptions = data.data.list;
            }
         });
         this.$http({
             url: `fangzhu/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.fangzhuOptions = data.data.list;
            }
         });

        },
        mounted() {
        },
        methods: {
            // 下载
            download(file){
                window.open(`${file}`)
            },
            // 初始化
            init(id,type) {
                if (id) {
                    this.id = id;
                    this.type = type;
                }
                if(this.type=='info'||this.type=='else'){
                    this.info(id);
                }
                // 获取用户信息
                this.$http({
                    url:`${this.$storage.get("sessionTable")}/session`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        var json = data.data;
                    } else {
                        this.$message.error(data.msg);
                    }
                });
            },
            zukeChange(id){
                this.$http({
                    url: `zuke/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.zukeForm = data.data;
                    }
                });
            },
            fangzhuChange(id){
                this.$http({
                    url: `fangzhu/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.fangzhuForm = data.data;
                    }
                });
            },
            // 多级联动参数
            info(id) {
                let _this =this;
                _this.$http({
                    url: `zulinhetong/info/${id}`,
                    method: 'get'
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        _this.ruleForm = data.data;
                        _this.zukeChange(data.data.zukeId)
                        _this.fangzhuChange(data.data.fangzhuId)
                    } else {
                        _this.$message.error(data.msg);
                    }
                });
            },
            // 提交
            onSubmit() {
                this.$refs["ruleForm"].validate(valid => {
                    if (valid) {
                        this.$http({
                            url:`zulinhetong/${!this.ruleForm.id ? "save" : "update"}`,
                            method: "post",
                            data: this.ruleForm
                        }).then(({ data }) => {
                            if (data && data.code === 0) {
                                this.$message({
                                    message: "操作成功",
                                    type: "success",
                                    duration: 1500,
                                    onClose: () => {
                                        this.parent.showFlag = true;
                                        this.parent.addOrUpdateFlag = false;
                                        this.parent.zulinhetongCrossAddOrUpdateFlag = false;
                                        this.parent.search();
                                        this.parent.contentStyleChange();
                                    }
                                });
                            } else {
                                this.$message.error(data.msg);
                            }
                        });
                    }
                });
            },
            // 获取uuid
            getUUID () {
                return new Date().getTime();
            },
            // 返回
            back() {
                this.parent.showFlag = true;
                this.parent.addOrUpdateFlag = false;
                this.parent.zulinhetongCrossAddOrUpdateFlag = false;
                this.parent.contentStyleChange();
            },
            //图片
            zulinhetongFileUploadChange(fileUrls){
                this.ruleForm.zulinhetongFile = fileUrls;
                this.addEditUploadStyleChange()
            },

            addEditStyleChange() {
                this.$nextTick(()=>{
                    // input
                    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputFontColor
                        el.style.fontSize = this.addEditForm.inputFontSize
                        el.style.borderWidth = this.addEditForm.inputBorderWidth
                        el.style.borderStyle = this.addEditForm.inputBorderStyle
                        el.style.borderColor = this.addEditForm.inputBorderColor
                        el.style.borderRadius = this.addEditForm.inputBorderRadius
                        el.style.backgroundColor = this.addEditForm.inputBgColor
                    })
                    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputLableColor
                        el.style.fontSize = this.addEditForm.inputLableFontSize
                    })
                    // select
                    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectFontColor
                        el.style.fontSize = this.addEditForm.selectFontSize
                        el.style.borderWidth = this.addEditForm.selectBorderWidth
                        el.style.borderStyle = this.addEditForm.selectBorderStyle
                        el.style.borderColor = this.addEditForm.selectBorderColor
                        el.style.borderRadius = this.addEditForm.selectBorderRadius
                        el.style.backgroundColor = this.addEditForm.selectBgColor
                    })
                    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectLableColor
                        el.style.fontSize = this.addEditForm.selectLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
                        el.style.color = this.addEditForm.selectIconFontColor
                        el.style.fontSize = this.addEditForm.selectIconFontSize
                    })
                    // date
                    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateFontColor
                        el.style.fontSize = this.addEditForm.dateFontSize
                        el.style.borderWidth = this.addEditForm.dateBorderWidth
                        el.style.borderStyle = this.addEditForm.dateBorderStyle
                        el.style.borderColor = this.addEditForm.dateBorderColor
                        el.style.borderRadius = this.addEditForm.dateBorderRadius
                        el.style.backgroundColor = this.addEditForm.dateBgColor
                    })
                    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateLableColor
                        el.style.fontSize = this.addEditForm.dateLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
                        el.style.color = this.addEditForm.dateIconFontColor
                        el.style.fontSize = this.addEditForm.dateIconFontSize
                        el.style.lineHeight = this.addEditForm.dateHeight
                    })
                    // upload
                    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
                    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.uploadHeight
                        el.style.color = this.addEditForm.uploadLableColor
                        el.style.fontSize = this.addEditForm.uploadLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
                        el.style.color = this.addEditForm.uploadIconFontColor
                        el.style.fontSize = this.addEditForm.uploadIconFontSize
                        el.style.lineHeight = iconLineHeight
                        el.style.display = 'block'
                    })
                    // 多文本输入框
                    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
                        el.style.height = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaFontColor
                        el.style.fontSize = this.addEditForm.textareaFontSize
                        el.style.borderWidth = this.addEditForm.textareaBorderWidth
                        el.style.borderStyle = this.addEditForm.textareaBorderStyle
                        el.style.borderColor = this.addEditForm.textareaBorderColor
                        el.style.borderRadius = this.addEditForm.textareaBorderRadius
                        el.style.backgroundColor = this.addEditForm.textareaBgColor
                    })
                    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
                        // el.style.lineHeight = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaLableColor
                        el.style.fontSize = this.addEditForm.textareaLableFontSize
                    })
                    // 保存
                    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
                        el.style.width = this.addEditForm.btnSaveWidth
                        el.style.height = this.addEditForm.btnSaveHeight
                        el.style.color = this.addEditForm.btnSaveFontColor
                        el.style.fontSize = this.addEditForm.btnSaveFontSize
                        el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
                        el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
                        el.style.borderColor = this.addEditForm.btnSaveBorderColor
                        el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnSaveBgColor
                    })
                    // 返回
                    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
                        el.style.width = this.addEditForm.btnCancelWidth
                        el.style.height = this.addEditForm.btnCancelHeight
                        el.style.color = this.addEditForm.btnCancelFontColor
                        el.style.fontSize = this.addEditForm.btnCancelFontSize
                        el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
                        el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
                        el.style.borderColor = this.addEditForm.btnCancelBorderColor
                        el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnCancelBgColor
                    })
                })
            },
            addEditUploadStyleChange() {
                this.$nextTick(()=>{
                    document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                })
            },
        }
    };
</script>
<style lang="scss">
.editor{
  height: 500px;

  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
}
.btn .el-button {
  padding: 0;
}</style>

