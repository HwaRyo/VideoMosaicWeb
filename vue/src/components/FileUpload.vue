<template>
    <div>
        <div
            id="upload-box"
            ondragover="dragHandler(event);"
            ondrop="dropHandler(event);"
            ondragenter="dragOverHandler(event);">
            <p id="copy">파일을 끌어오거나, 파일을 선택해주세요.</p>
            <div class="button-bg">
                <label id="fake-file-button">
                    <svg
                        width="25"
                        height="24"
                        viewBox="0 0 25 24"
                        fill="none"
                        xmlns="http://www.w3.org/2000/svg">
                        <path
                            fill-rule="evenodd"
                            clip-rule="evenodd"
                            d="M3.15812 8.39647C3.7015 4.20937 7.27393 1 11.5776 1C15.767 1 19.2713 4.04295 19.9502 8.07791C22.3007 8.48907 24.0776 10.5407 24.0776 13C24.0776 15.7613 21.8388 18 19.0776 18H16.0776C15.5253 18 15.0776 17.5523 15.0776 17C15.0776 16.4477 15.5253 16 16.0776 16H19.0776C20.7343 16 22.0776 14.6567 22.0776 13C22.0776 11.3402 20.7298 9.99106 19.0597 10.003C18.5301 10.0068 18.0894 9.59702 18.0547 9.06859C17.8309 5.66301 15.0035 3 11.5776 3C8.10931 3 5.26146 5.72787 5.09439 9.18428C5.07316 9.62345 4.76757 9.99723 4.34138 10.1053C3.01839 10.4408 2.07755 11.6256 2.07755 13C2.07755 14.6567 3.42084 16 5.07755 16H8.07755C8.62984 16 9.07755 16.4477 9.07755 17C9.07755 17.5523 8.62984 18 8.07755 18H5.07755C2.31627 18 0.0775528 15.7613 0.0775528 13C0.0775528 10.9508 1.32603 9.15685 3.15812 8.39647ZM13.0776 22V11.4142L14.3704 12.7071C14.761 13.0976 15.3941 13.0976 15.7847 12.7071C16.1752 12.3166 16.1752 11.6834 15.7847 11.2929L12.7851 8.29329L13.0776 11.4142L12.7825 8.29078C12.6017 8.11106 12.3526 8 12.0776 8C11.942 8 11.8127 8.02699 11.6948 8.07588C11.5768 8.12468 11.4663 8.19702 11.3704 8.29289L8.37045 11.2929C7.97992 11.6834 7.97992 12.3166 8.37045 12.7071C8.76097 13.0976 9.39414 13.0976 9.78466 12.7071L11.0776 11.4142V22C11.0776 22.5523 11.5253 23 12.0776 23C12.6298 23 13.0776 22.5523 13.0776 22Z"
                            fill="#182D3B"/>
                    </svg>
                    Upload
                    <input type="file" class="button" id="upload-btn" onchange="handleFiles();"></label>
                </div>
                <div id="upload-animation"></div>
            </div>

            <div class="section bg">
                <div class="container">
                    <h1>사용방법</h1>
                    <div class="col two bg margin extrapad">
                        <h1 class="icon side">1</h1>
                        <span class="feature side">설명</span>
                        <span class="side">
                            - 설명설명</span>
                        <p class="side">설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명</p>
                    </div>
                    <div class="col two bg margin extrapad">
                        <h1 class="icon side">2</h1>
                        <span class="feature side">설명</span>
                        <span class="side">
                            - 설명설명</span>
                        <p class="side">설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명</p>
                    </div>
                    <div class="group margin"></div>
                    <div class="col two bg margin extrapad">
                        <span class="feature side">설명</span>
                        <span class="side">
                            - 설명설명</span>
                        <p class="side">설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명</p>
                    </div>
                    <div class="col two bg margin extrapad">
                        <h1 class="icon side">4</h1>
                        <span class="feature side">설명</span>
                        <span class="side">
                            - 설명설명</span>
                        <p class="side">설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명</p>
                    </div>
                    <div class="group"></div>
                </div>
            </div>
        </div>
    </template>

  