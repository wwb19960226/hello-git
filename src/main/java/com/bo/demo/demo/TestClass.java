package com.bo.demo.demo;

/*
*
以下两个函数是从我的扫描归档程序中提取出来的，开发语言为C#。

对应的界面上有三个控件，一个是文本框tbxQR，一个是WebBrowser控件webBrowser1,一个是组合下拉列表控件comboBox开发商。

光标定位在tbxQR中，用扫描枪扫描二维码后，即可触发第一个函数tbxQR_KeyPress(object sender, KeyPressEventArgs e)执行，进而调用第二个函数GetNames(string transObj)执行。

GetNames(string transObj)函数，根据传入的二维码明码，解析后生成买卖双方姓名再返回。
* */

public class TestClass {
   /* private void tbxQR_KeyPress(object sender, KeyPressEventArgs e)
    {
        if (e.KeyChar == (char)Keys.Return)
        {
            HYQRBARCODELib.QRCode obj = new HYQRBARCODELib.QRCode();
            string str = obj.DeBarCodeString(this.tbxQR.Text);//解码得到明码

            string names = GetNames(str);
            if (names != "")
            {
                if (webBrowser1.Url.ToString().Contains(Properties.Settings.Default.RootURL + "general/other/xslmodify.asp?dazldm=6624&selectfj=&selectnf=&")||
                        webBrowser1.Url.ToString().Contains(Properties.Settings.Default.RootURL + "general/other/xslmodify.asp?dazldm=6611&selectfj=&selectnf=&"))
                {
                    HtmlElement elem;

                    elem = webBrowser1.Document.GetElementById("qymc");
                    if (elem != null)
                        elem.SetAttribute("value", names);

                    elem = webBrowser1.Document.GetElementById("sj");
                    if (elem != null)
                        elem.SetAttribute("value", tbx时间.Text);

                    elem = webBrowser1.Document.GetElementById("mxys");
                    if (elem != null)
                    {
                        string[] pagenums = tbx页数.Text.Split(new string[] { " " }, StringSplitOptions.RemoveEmptyEntries);
                        if (pagenums.Length < 1)
                        {
                            MessageBox.Show("缺少页数数据，请在页面上进行手工操作!");
                        }
                        else
                        {
                            elem.SetAttribute("value", pagenums[0]);
                            tbx页数.Text = "";
                            for (int i = 1; i < pagenums.Length; i++)
                                tbx页数.Text += pagenums[i] + " ";

                            timer5.Start();
                        }
                    }
                }
            }

            this.tbxQR.Text = "";
        }
    }*/

    public static void main(String[] args) {

       /* HYQRBARCODELib.QRCode obj = new HYQRBARCODELib.QRCode();
        string str = obj.DeBarCodeString(this.tbxQR.Text);//解码得到明码*/

        String name = getNames("<Head0815030901000780>504b030414000200080072180f43746a5f72ec000000190100000f001100433a2f2f515254656d70312e64617455540d0007ed440c52ed440c52ed440c5235cccb4ac3601005e0a771199d99ffbef63da6a0b871e3c675de2560c11a5d349a1643f3870a4d8522c6d65ee8420abe81ab522898483d67319bef0c5f9d5d5e9c5fb7a0091d0e9f1a879a1413a008c006a8180d27fb321f6f7b711515ebf94f2f7eccab68bc45918d5eda947ccbb4fd792789b211031c1e21fb4ebf78bd5ddc24fb493e2d978b748d4e686c1401a80074008e8d39969a052fa3f93da354cd9ae944719d61f6b109b1290202a1d304aede3aa010018e42145a215aa19de5d9c62745f9c7a5a8b944671b6e0084fce71641096d1471b7eb3bc3a7c1b45fa4ab64e71f066fb3eafdeb399ef85f504b0102170b14000200080072180f43746a5f72ec000000190100000f0009000000000000002000808100000000433a2f2f515254656d70312e6461745554050007ed440c52504b05060000000001000100460000002a0100000000</tag>");
        System.out.println(name);
    }

    private static String getNames(String transObj)
    {
        //判定是否空业务条形码
        String[] transObjArray = transObj.split("^");
        if (transObjArray.length == 1 && transObj == "00000000000000000000")
        {
            /*MessageBox.Show("扫描条形码内容为空！");*/
            return "";
        }

        //如果明文不为"object_"开头则表示条码图片扫描不全，提示继续扫描
        if (transObj.indexOf("object") != 1)
        {
            /*this.tbxQR.Focus();
            MessageBox.Show("请扫描全部二维条形码图片，否则无法解码！");*/
            return "";
        }

        String retstr = "买方:";

        //买方信息----------------------------------------
        String[] mfxx = transObjArray[19].split("~");
        int mfxxArrayLength = mfxx.length;
        int mfxxCount = mfxxArrayLength / 6;
        for (int i = 1; i <= mfxxCount; i++)
        {
            //纳税人名称
            if (i > 1)
                retstr += "、" + mfxx[0 + (6 * (i - 1))];
            else
                retstr += mfxx[0 + (6 * (i - 1))];
        }

        retstr += " 卖方:";

        //卖方信息----------------------------------------------
        String[] mmfxx = transObjArray[18].split("~");
        int mmfxxArrayLength = mmfxx.length;
        int mmfxxCount = mmfxxArrayLength / 6;
        for (int i = 1; i <= mmfxxCount; i++)
        {
            //卖方姓名
            if (i > 1)
                retstr += "、" + mmfxx[0 + (6 * (i - 1))];
            else
                retstr += mmfxx[0 + (6 * (i - 1))];
        }

        /*if (comboBox开发商.Enabled && comboBox开发商.Text != null && retstr.EndsWith(" 卖方:"))
        {
            retstr += comboBox开发商.Text;
        }*/

        return retstr;
    }


}
