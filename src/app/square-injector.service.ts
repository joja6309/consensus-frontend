import { Injectable } from '@angular/core';

@Injectable()
export class SquareInjectorService {
  public rowPoint: number; 
  public columnPoint: number;
  public cnvH: number;
  public cnvW: number;
  public imageSrc: string; 


  constructor() { }

}
