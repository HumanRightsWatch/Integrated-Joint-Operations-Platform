# The Integrated Joint Operations Platform: the heart of mass surveillance in Xinjiang

This repository includes the press release and the 68-page Human Rights Watch (HRW) report, “China’s Algorithms of Repression: Reverse Engineering a Xinjiang Police Mass Surveillance App.” It also includes translations of the press release and the report’s summary and recommendations in Arabic, Bahasa Indonesian, Chinese, French, Spanish, Turkish, Uyghur. In addition, it includes the digital forensic artifacts discovered or developed during the course of the 2018-2019 HRW investigation reported in ”China’s Algorithms of Repression” (available at: https://www.hrw.org/node/329384).

If you have questions about the report, the IJOP android application, or the decompiled code excerpts published here, please write us at ijop@hrw.org .


## Reports

| --- | --- | --- |
| Type | Language | Link | 
| Full report | English | https://www.hrw.org/node/329384 | 
| Report summary and recommendations | Arabic | https://www.hrw.org/sites/default/files/report_pdf/201905china_ijop_sum_rec_arabic_0.pdf |
| Report summary and recommendations | Bahasa | https://www.hrw.org/sites/default/files/report_pdf/201905china_ijop_sum_recs_bahasa_0.pdf|
| Report summary and recommendations | French | https://www.hrw.org/sites/default/files/report_pdf/201905china_ijop_sum_rec_french.pdf |
| Report summary and recommendations | Spanish | https://www.hrw.org/sites/default/files/report_pdf/201905china_ijop_sum_recs_spanish_0.pdf |
| Report summary and recommendations | Uyghur | https://www.hrw.org/sites/default/files/report_pdf/201905china_ijop_sum_recs_uyghur_1.pdf |
| Report summary and recommendations | Turkish | https://www.hrw.org/sites/default/files/report_pdf/201905china_ijop_sum_recs_turkish.pdf |
| Report summary and recommendations | Chinese | https://www.hrw.org/sites/default/files/report_pdf/201905china_ijop_sum_rec_chinese.pdf |
| Press release | English | https://www.hrw.org/video-photos/interactive/2019/05/02/china-how-mass-surveillance-works-xinjiang |
| Press release | Arabic| https://www.hrw.org/ar/news/2019/05/02/329665|
| Press release | Chinese| https://www.hrw.org/zh-hans/news/2019/05/02/329666|
| Press release | German| https://www.hrw.org/de/news/2019/05/02/china-wie-massenueberwachung-xinjiang-funktioniert|
| Press release | Bahasa Indonesian| https://www.hrw.org/id/news/2019/05/02/329562|
| Press release | French| https://www.hrw.org/fr/news/2019/05/02/chine-recours-une-application-pour-la-surveillance-de-masse-au-xinjiang|
| Press release | Spanish| https://www.hrw.org/es/news/2019/05/02/china-como-funciona-la-vigilancia-masiva-en-xinjiang|
| Press release | Turkish| https://www.hrw.org/tr/news/2019/05/02/329642|


## Licenses

All HRW documents (including the text of the original report in English, and the translations of the summary) in this repository are provided under Creative Commons Attribution-NonCommercial-NoDerivs 3.0 United States (CC BY-NC-ND 3.0 US) which is available in full here and summarized here. The Creative Commons License referred to here is perpetual for the duration of the applicable copyright of the work.

# Technical Information

**Forensic Artifacts:** This repository contains selections of code decompiled from the IJOP android application, which may be further updated. Selections that were included were those identified as relevant to the 2018-2019 HRW investigation reported in [China’s Algorithms of Repression report](https://www.hrw.org/node/329384). 

**Redactions:** All decompiled code that is released will be reviewed the research team and HRWs Information Security team to redact any API-keys, usernames, passwords or other authenticating information.  All redactions will be noted in the [redaction log]().

**APK Hashes:** HRW does not have plans to release the full application (APK) as it can be freely downloaded by the public from existing websites. If you would like to verify that the application you downloaded is the same as the application that analyzed by the HRW research team you can compare it to the following hashes

|Hash Type|Hash|Filename|
| --- | --- | --- |
|md5sum|c0d0eb41dee70910eee1dc8f468051db|yitihualianhezuozhanpingtai_downcc.apk
|sha1sum|861d574183889de45543143149c0145032c02302|yitihualianhezuozhanpingtai_downcc.apk|
|sha256sum|7171fbde943355f18dc7585acc08e7b9c5fffd02ab8fc6870c6fafd1665ec186|yitihualianhezuozhanpingtai_downcc.apk|

**Source Code:** The decompiled code was extracted from the original APK using [jadx](https://github.com/skylot/jadx) using the following command. `jadx -d source_code yitihualianhezuozhanpingtai_downcc.apk` You can view the full list of decompiled code contained in the application in the [file-tree.]()

百花齊放.
