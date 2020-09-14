package com.example.bsptechnologies.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MainResults {

@SerializedName("Status")
@Expose
private Integer status;
@SerializedName("Result")
@Expose
private List<Result> result = null;
@SerializedName("Message")
@Expose
private String message;
@SerializedName("RecordCount")
@Expose
private String recordCount;

public Integer getStatus() {
return status;
}

public void setStatus(Integer status) {
this.status = status;
}

public List<Result> getResult() {
return result;
}

public void setResult(List<Result> result) {
this.result = result;
}

public String getMessage() {
return message;
}

public void setMessage(String message) {
this.message = message;
}

public String getRecordCount() {
return recordCount;
}

public void setRecordCount(String recordCount) {
this.recordCount = recordCount;
}

}