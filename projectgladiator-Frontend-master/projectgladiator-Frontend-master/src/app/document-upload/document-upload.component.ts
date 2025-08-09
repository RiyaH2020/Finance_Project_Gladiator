import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-document-upload',
  templateUrl: './document-upload.component.html',
  styleUrls: ['./document-upload.component.css']
})
export class DocumentUploadComponent implements OnInit {
register:RegisterDoc=new RegisterDoc();
document:File;//File;
  constructor(private userService: UserService, private router: Router) { }

  Check(){
    alert(this.register.username);
  }
  onFileChange(event){
    this.document=event.target.files[0];
  }

  upload(){
    let formData:FormData=new FormData();
    formData.append('username',sessionStorage.getItem('uname'));
    formData.append('document',this.document);
    console.log(formData.get('document'));
    console.log(sessionStorage.getItem('uname'));
    //code to hit the server missing right now...
    this.userService.documentUpload(formData).subscribe(response =>{
      alert(JSON.stringify(response));
    })
    this.router.navigate(['index']);
  
}
ngOnInit() {
}
}

export class RegisterDoc{
  username:string;
}
