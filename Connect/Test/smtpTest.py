import smtplib
from email.mime.text import MIMEText

class SmtpTest:
    def __init__(self, userEmail, pw):
        self.smtpServer =  "smtp.naver.com"
        self.projectEmail = "wjstmdnr@naver.com"
        self.projectPw = pw
        self.smtpPort = 587
        self.userEmail = userEmail

    def send(self, title, content):
            
        message = MIMEText(content,_charset="utf8")

        message['Subject'] = title
        message['From'] = smtp_info['smtp_user_id']
        message['To'] = to
                
        smtp = smtplib.SMTP(smtp_info['smtp_server'], smtp_info['smtp_port'])
        smtp.ehlo
        smtp.starttls()
        smtp.login(sender_id , sender_pw)
                
        smtp.sendmail(message['From'], message['To'].split(','), message.as_string())

        smtp.quit()