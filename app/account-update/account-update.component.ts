import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import {Observable} from 'rxjs';
@Component({
  selector: 'app-account-update',
  templateUrl: './account-update.component.html',
  styleUrls: ['./account-update.component.css']
})
export class AccountUpdateComponent implements OnInit {
  password:string;
  repeatPassword:string;
  success:boolean=false;
  invalid:boolean=false;
  private users: Observable<any>;
  constructor(private userService: UserService, private authService: AuthService, private router: Router) { }
  changepassword():void {
    if(this.password===this.repeatPassword) {
      this.success=true;
      this.invalid=false;
      this.userService.updateUser(this.password).subscribe();
    }
    else {
      this.invalid=true;
      this.success=false;
    }
  }
  ngOnInit() {
    if (!this.authService.isLoggedin) {
      this.router.navigate(['/']);
      this.reloadData();
    }
  }
  private reloadData() {
    this.users = this.userService.getUsers();
  }
  deleteUser(id: number) {
    this.userService.deleteUser(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

}
