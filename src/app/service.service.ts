import { UserModel } from './UserModel';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
url="http://localhost:9091:api/"
  constructor(private http:HttpClient) { }

  createUser(user:UserModel):Observable<UserModel>{
    return this.http.post<UserModel>(this.url + "uploadFile", user);
  }
  getAllUsers():Observable<UserModel[]>{
    return this.http.get<UserModel[]>(this.url+"/getAllUsers");
  }
  getUserById(id:number):Observable<UserModel>{
    return this.http.get<UserModel>(this.url+"/getUserById/"+id);

  }
  updateUser(id:number,user:UserModel):Observable<UserModel>{
    return this.http.put<UserModel>(this.url+"/updateUser/"+id,user);

  }
  deleteUser(id:number){
    this.http.delete(this.url+"deleteUser/"+id);
  }

}
