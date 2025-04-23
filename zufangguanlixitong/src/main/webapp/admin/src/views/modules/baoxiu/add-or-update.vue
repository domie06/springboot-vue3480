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
                <el-col :span="12"  v-if="sessionTable !='weixiurenyuan' && sessionTable !='zuke'">
                    <el-form-item class="select" v-if="type!='info'"  label="维修人员" prop="weixiurenyuanId">
                        <el-select v-model="ruleForm.weixiurenyuanId" :disabled="ro.weixiurenyuanId" filterable placeholder="请选择维修人员" @change="weixiurenyuanChange">
                            <el-option
                                    v-for="(item,index) in weixiurenyuanOptions"
                                    v-bind:key="item.id"
                                    :label="item.weixiurenyuanName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='weixiurenyuan' && !(sessionTable =='zuke' && type!='info') ">
                    <el-form-item class="input" v-if="type!='info'"  label="维修人员姓名" prop="weixiurenyuanName">
                        <el-input v-model="weixiurenyuanForm.weixiurenyuanName"
                                  placeholder="维修人员姓名" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="维修人员姓名" prop="weixiurenyuanName">
                            <el-input v-model="ruleForm.weixiurenyuanName"
                                      placeholder="维修人员姓名" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='weixiurenyuan' && !(sessionTable =='zuke' && type!='info')  ">
                    <el-form-item class="input" v-if="type!='info'"  label="维修人员手机号" prop="weixiurenyuanPhone">
                        <el-input v-model="weixiurenyuanForm.weixiurenyuanPhone"
                                  placeholder="维修人员手机号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="维修人员手机号" prop="weixiurenyuanPhone">
                            <el-input v-model="ruleForm.weixiurenyuanPhone"
                                      placeholder="维修人员手机号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='weixiurenyuan' && !(sessionTable =='zuke' && type!='info')  ">
                    <el-form-item class="input" v-if="type!='info'"  label="维修人员身份证号" prop="weixiurenyuanIdNumber">
                        <el-input v-model="weixiurenyuanForm.weixiurenyuanIdNumber"
                                  placeholder="维修人员身份证号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="维修人员身份证号" prop="weixiurenyuanIdNumber">
                            <el-input v-model="ruleForm.weixiurenyuanIdNumber"
                                      placeholder="维修人员身份证号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="sessionTable !='weixiurenyuan' && !(sessionTable =='zuke' && type!='info')  ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.weixiurenyuanPhoto" label="维修人员头像" prop="weixiurenyuanPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (weixiurenyuanForm.weixiurenyuanPhoto || '').split(',')" :src="item" width="100" height="100">
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.weixiurenyuanPhoto" label="维修人员头像" prop="weixiurenyuanPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.weixiurenyuanPhoto || '').split(',')" :src="item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='weixiurenyuan' && !(sessionTable =='zuke' && type!='info')  ">
                    <el-form-item class="input" v-if="type!='info'"  label="维修人员电子邮箱" prop="weixiurenyuanEmail">
                        <el-input v-model="weixiurenyuanForm.weixiurenyuanEmail"
                                  placeholder="维修人员电子邮箱" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="维修人员电子邮箱" prop="weixiurenyuanEmail">
                            <el-input v-model="ruleForm.weixiurenyuanEmail"
                                      placeholder="维修人员电子邮箱" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <input id="updateId" name="id" type="hidden">
            <input id="zukeId" name="zukeId" type="hidden">
            <input id="weixiurenyuanId" name="weixiurenyuanId" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="报修编号" prop="baoxiuUuidNumber">
                       <el-input v-model="ruleForm.baoxiuUuidNumber"
                                 placeholder="报修编号" clearable  :readonly="ro.baoxiuUuidNumber"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="报修编号" prop="baoxiuUuidNumber">
                           <el-input v-model="ruleForm.baoxiuUuidNumber"
                                     placeholder="报修编号" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="报修物品类型" prop="baoxiuTypes">
                        <el-select v-model="ruleForm.baoxiuTypes" :disabled="ro.baoxiuTypes" placeholder="请选择报修物品类型">
                            <el-option
                                v-for="(item,index) in baoxiuTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="报修物品类型" prop="baoxiuValue">
                        <el-input v-model="ruleForm.baoxiuValue"
                            placeholder="报修物品类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="故障类型" prop="guzhangTypes">
                        <el-select v-model="ruleForm.guzhangTypes" :disabled="ro.guzhangTypes" placeholder="请选择故障类型">
                            <el-option
                                v-for="(item,index) in guzhangTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="故障类型" prop="guzhangValue">
                        <el-input v-model="ruleForm.guzhangValue"
                            placeholder="故障类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="报修位置" prop="baoxiuAddress">
                       <el-input v-model="ruleForm.baoxiuAddress"
                                 placeholder="报修位置" clearable  :readonly="ro.baoxiuAddress"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="报修位置" prop="baoxiuAddress">
                           <el-input v-model="ruleForm.baoxiuAddress"
                                     placeholder="报修位置" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="24">
                    <el-form-item v-if="type!='info'"  label="上报详情" prop="forumContent">
                        <editor style="min-width: 200px; max-width: 600px;"
                                v-model="ruleForm.forumContent"
                                class="editor"
                                action="file/upload">
                        </editor>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.forumContent" label="上报详情" prop="forumContent">
                            <span v-html="ruleForm.forumContent"></span>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if=" !(sessionTable =='zuke' && type!='info')">
                    <el-form-item class="select" v-if="type!='info'"  label="维修状态" prop="weixiuzhuangtaiTypes">
                        <el-select v-model="ruleForm.weixiuzhuangtaiTypes" :disabled="ro.weixiuzhuangtaiTypes" placeholder="请选择维修状态">
                            <el-option
                                v-for="(item,index) in weixiuzhuangtaiTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="维修状态" prop="weixiuzhuangtaiValue">
                        <el-input v-model="ruleForm.weixiuzhuangtaiValue"
                            placeholder="维修状态" readonly></el-input>
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
                weixiurenyuanForm: {},
                ro:{
                    zukeId: false,
                    weixiurenyuanId: false,
                    baoxiuUuidNumber: false,
                    baoxiuTypes: false,
                    guzhangTypes: false,
                    baoxiuAddress: false,
                    insertTime: false,
                    forumContent: false,
                    weixiuzhuangtaiTypes: false,
                },
                ruleForm: {
                    zukeId: '',
                    weixiurenyuanId: '',
                    baoxiuUuidNumber: new Date().getTime(),
                    baoxiuTypes: '',
                    guzhangTypes: '',
                    baoxiuAddress: '',
                    insertTime: '',
                    forumContent: '',
                    weixiuzhuangtaiTypes: '',
                },
                baoxiuTypesOptions : [],
                guzhangTypesOptions : [],
                weixiuzhuangtaiTypesOptions : [],
                zukeOptions : [],
                weixiurenyuanOptions : [],
                rules: {
                   zukeId: [
                              { required: true, message: '租客不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   weixiurenyuanId: [
                              { required: true, message: '维修人员不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   baoxiuUuidNumber: [
                              { required: true, message: '报修编号不能为空', trigger: 'blur' },
                          ],
                   baoxiuTypes: [
                              { required: true, message: '报修物品类型不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   guzhangTypes: [
                              { required: true, message: '故障类型不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   baoxiuAddress: [
                              { required: true, message: '报修位置不能为空', trigger: 'blur' },
                          ],
                   insertTime: [
                              { required: true, message: '上报时间不能为空', trigger: 'blur' },
                          ],
                   forumContent: [
                              { required: true, message: '上报详情不能为空', trigger: 'blur' },
                          ],
                   weixiuzhuangtaiTypes: [
                              { required: true, message: '维修状态不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
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
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=baoxiu_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.baoxiuTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=guzhang_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.guzhangTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=weixiuzhuangtai_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.weixiuzhuangtaiTypesOptions = data.data.list;
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
             url: `weixiurenyuan/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.weixiurenyuanOptions = data.data.list;
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
            weixiurenyuanChange(id){
                this.$http({
                    url: `weixiurenyuan/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.weixiurenyuanForm = data.data;
                    }
                });
            },
            // 多级联动参数
            info(id) {
                let _this =this;
                _this.$http({
                    url: `baoxiu/info/${id}`,
                    method: 'get'
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        _this.ruleForm = data.data;
                        _this.zukeChange(data.data.zukeId)
                        _this.weixiurenyuanChange(data.data.weixiurenyuanId)
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
                            url:`baoxiu/${!this.ruleForm.id ? "save" : "update"}`,
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
                                        this.parent.baoxiuCrossAddOrUpdateFlag = false;
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
                this.parent.baoxiuCrossAddOrUpdateFlag = false;
                this.parent.contentStyleChange();
            },
            //图片

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

