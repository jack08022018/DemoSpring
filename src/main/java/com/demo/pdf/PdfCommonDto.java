package com.demo.pdf;

import com.demo.configuration.exception.ErrorResponse;

public class PdfCommonDto {
    private int totalPage;

    private PdfCommonDto(PdfCommonDto.PdfCommonDtoBuilder builder) {
        this.totalPage = builder.totalTage;
    }

    public static PdfCommonDto.PdfCommonDtoBuilder builder() {
        return new PdfCommonDto.PdfCommonDtoBuilder();
    }

    public static class PdfCommonDtoBuilder {
        private int totalTage;

        public PdfCommonDto.PdfCommonDtoBuilder setotalPage(int totalTage) {
            this.totalTage = totalTage;
            return this;
        }

        public PdfCommonDto build() {
            return new PdfCommonDto(this);
        }
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
