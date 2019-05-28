/**
 * 
 */
var temp;
var Y = new Array();
var E = new Array();
var S = new Array();
Y = new Array("哲学","经济学","法学","教育学","理学","工学");
/*哲学*/ E[0] = new Array("哲学");
/*经济学*/ E[1] = new Array("理论经济学","应用经济学");
/*法学    */ E[2] = new Array("法学","政治学","社会学","民族学","");
/*教育学    */ E[3] = new Array("教育学","心理学","体育学");
/*理学  */ E[4] = new Array("数学","物理学","化学","天文学","地理学","大气科学","海洋科学","地球物理学","地质学","生物学","系统科学");
/*工学  */ E[5] = new Array("力学","机械工程","材料科学与工程","冶金工程","电气工程","信息与通信工程","计算机科学与技术","建筑学");


for(temp in E)
{
    S[temp] = new Array();
}
/*哲学  */S[0][0] = new Array("马克思主义哲学,中国哲学,外国哲学,逻辑学,伦理学,美学,宗教学,科学技术哲学");
/*理论经济学   */S[1][0] = new Array("政治经济学,经济思想史,经济史,西方经济学,世界经济,人口、资源与环境经济学");
/*应用经济学*/S[1][1] = new Array("国民经济学,区域经济学,财政学,金融学,产业经济学,国际贸易学,劳动经济学,统计学,数量经济学,国防经济");
/*法学    */S[2][0] = new Array("法学理论,法律史,宪法学与行政法学,刑法学,民商法学,诉讼法学,经济法学,环境与资源保护法学,国际法学,军事法学");
/*政治学   */S[2][1] = new Array("政治学理论,中外政治制度,科学社会主义与国际共产主义运动,中共党史,国际政治,国际关系,外交学");
/*社会学    */S[2][2] = new Array("社会学,人口学,人类学,民俗学");
/*民族学    */S[2][3] = new Array("民族学,马克思主义民族理论与政策,中国少数民族经济,中国少数民族史,中国少数民族艺术");
/*教育学    */S[3][0] = new Array("教育学原理,课程与教学论,教育史,比较教育学,学前教育学,高等教育学,成人教育学,职业技术教育学,特殊教育学");
/*心理学   */S[3][1] = new Array("基础心理学,发展与教育心理学,应用心理学");
/*体育学 */S[3][2] = new Array("体育人文社会学,运动人体科学,体育教育训练学,民族传统体育学");
/*数学 */S[4][0] = new Array("基础数学,计算数学,概率论与数理统计,应用数学","运筹学与控制论","物理学");
/*物理学 */S[4][1] = new Array("理论物理,粒子物理与原子核物理,原子与分子物理,等离子物理,凝聚态物理,声学,光学,无线电物理");
/*化学 */S[4][2] = new Array("无机化学,分析化学,有机化学,物理化学,高分子化学与物理");
/*天文学 */S[4][3] = new Array("天体物理,天体测量与天体力学");
/*地理学 */S[4][4] = new Array("自然地理学,人文地理学,地图学与地理信息系统");
/*大气科学 */S[4][5] = new Array("气象学,大气物理学与大气环境");
/*海洋科学 */S[4][6] = new Array("物理海洋学,海洋化学,海洋生物学,海洋地质");
/*地球物理学 */S[4][7] = new Array("固体地球物理学,空间物理学");
/*地质学学 */S[4][8] = new Array("矿物学、岩石学、矿床学,地球化学,古生物与地层学,构造地质学");
/*生物学*/S[4][9] = new Array("植物学,动物学,生理学,水生物学,微生物学,神经生物学,遗传学,发育生物学,细胞生物学,生物化学与分子生物学,生物物理学");
/*系统科学 */S[4][10] = new Array("系统理论,系统分析与集成");
/*力学*/S[5][0] = new Array("一般力学与力学基础,固体力学,流体力学,工程力学");
/*机械工程*/S[5][1] = new Array("机械制造及其自动化,机械电子工程,机械设计及理论,车辆工程");
/*材料科学与工程*/S[5][2] = new Array("材料物理与化学,材料学,材料加工工程");
/*冶金工程*/S[5][3] = new Array("冶金物理与化学,钢铁冶金,有色金属冶金");
/*电气工程*/S[5][4] = new Array("电机与电气,电力系统及其自动化,高电压与绝缘技术,电力电子与电力传动,电工理论与新技术");
/*信息与通信工程*/S[5][5] = new Array("通信与信息系统,信号与信息处理");
/*计算机科学与技术*/S[5][6] = new Array("计算机系统结构,计算机软件与理论,计算机应用技术");
/*建筑学*/S[5][7] = new Array("城市规划与设计,建筑技术科学");


function createEjxueke(sejName)
{
    var oXueke = new Object();
    oXueke.yjxueke = "";
    oXueke.ejxueke = sejName;
    oXueke.sjxueke = new Array();
    oXueke.yindex = -1;//所属一级学科在一级学科数组中的位置index
    oXueke.eindex = -1;//二级学科在所属二级学科中的位置index（二者用来确定区域数组）
   
    var m = -1;var n = -1;
    for(var i = 0; i < E.length; i++)
    {
        for(var j=0; j < E[i].length; j++)
        {
            if(E[i][j] == sejName)
            {
            	oXueke.yjxueke = Y[i];
            	oXueke.sjxueke = S[i][j];
            	oXueke.yindex = i;
            	oXueke.eindex = j;
                break;
            }
        }
       
        if(oXueke.yjxueke != "")
        {
            break;
        }
    }
   
    return oXueke;
}
/*三级、一级学科、二级学科、三级学科*/
/*面向对象*/
function oMenu(selYJxueke,selEJxueke,selSJxueke)
{
    ///selYJxueke一级学科的select控件id
    ///selEJxueke二级学科的select控件id
    ///selSJxueke三级学科的select控件id
    this.oYjxueke = document.getElementById(selYJxueke);   
   
    ///二级学科变化，初始化三级学科
    function fnInitSjxueke(ejxueke)
    {
        var objEjxueke = createEjxueke(ejxueke);
        var sjxueke = objEjxueke.sjxueke.toString().split(',');
        ClearSelect(selSJxueke,"请选择三级学科");
        InitSelect(selSJxueke,sjxueke,"");
    };
   
    ///初始化二级学科
    function fnInitEjxueke(yjxueke)
    { 
        for(var i = 0;i < Y.length;i++)
        {
            if(Y[i] == yjxueke)
            {
                ClearSelect(selEJxueke,"请选择二级学科");
                InitSelect(selEJxueke,E[i],"");
                ClearSelect(selSJxueke,"请先选择二级学科");
                document.getElementById(selEJxueke).onchange = function (){fnInitSjxueke(this.value);};
                break;
            }
        }       
    };
   
    ///初始化一级学科
    this.fnInitYjxueke = function(){
        InitSelect(selYJxueke,Y,"请选择一级学科");
        ClearSelect(selEJxueke,"请先选择一级学科");
        ClearSelect(selSJxueke,"请先选择二级学科");       
        this.oYjxueke.onchange = function (){fnInitEjxueke(this.value);};
    };
///初始化select控件
    function InitSelect(obj,aInitValue,sMenu)
    {
        ///obj:要初始化的select控件对象的id
        ///aInitValue:要初始化的数组值
        ///sMenu:在select控件头部要添加的option，value为空；如果该参数为空，则只初始化aInitValue而不加头部
        if(sMenu != "")
        {
            document.getElementById(obj).options.add(new Option(sMenu,""));
        }
       
        for(var i = 0; i < aInitValue.length; i++)
        {
            document.getElementById(obj).options.add(new Option(aInitValue[i],aInitValue[i]));
        }       
    }
   
    function ClearSelect(obj,sMenu)
    {       
        document.getElementById(obj).options.length = 0;
        document.getElementById(obj).options.add(new Option(sMenu,""));       
    }   
}
var oMenu = new oMenu("selYJxueke","selEJxueke","selSJxueke");//select ID
    oMenu.fnInitYjxueke();